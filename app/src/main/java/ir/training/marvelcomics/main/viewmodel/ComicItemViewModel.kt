package ir.training.marvelcomics.main.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.usecase.comic.item.ComicItemUseCase
import ir.training.marvelcomics.main.state.ComicItemState
import ir.training.marvelcomics.main.view.detail.contract.ComicItemEffect
import ir.training.marvelcomics.main.view.detail.contract.ComicItemEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class ComicItemViewModel @Inject constructor(
    private val comicItemUseCase: ComicItemUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(ComicItemState())
    val state: StateFlow<ComicItemState> = _state.asStateFlow()

    private val _comic = MutableStateFlow<ComicItem?>(null)
    val comic: StateFlow<ComicItem?> = _comic.asStateFlow()

    private val _effectFlow = MutableSharedFlow<ComicItemEffect>(1)
    val effectFlow = _effectFlow.asSharedFlow()

    init {
        savedStateHandle.get<Int>("noteId")?.let { noteId ->
            _state.update { state ->
                state.copy(comicId = noteId)
            }
            getComicItem()
        }
    }

    private fun getComicItem() {
        viewModelScope.launch {
            comicItemUseCase(_state.value.comicId, _comic)
        }
    }

    fun onEvent(event: ComicItemEvent) {
        when (event) {
            is ComicItemEvent.OnBackButtonClicked -> {
                _effectFlow.tryEmit(ComicItemEffect.NavigateToComicListScreen)
            }
        }
    }

}
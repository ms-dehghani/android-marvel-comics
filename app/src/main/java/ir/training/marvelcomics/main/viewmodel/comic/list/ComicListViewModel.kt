package ir.training.marvelcomics.main.viewmodel.comic.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.training.marvelcomics.domain.usecase.comic.list.ComicListUseCase
import ir.training.marvelcomics.main.state.base.PageState
import ir.training.marvelcomics.main.state.comic.list.ComicListState
import ir.training.marvelcomics.main.view.pages.comic.list.contract.ComicListEffect
import ir.training.marvelcomics.main.view.pages.comic.list.contract.ComicListEvent
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

const val PAGE_SIZE = 10

@HiltViewModel
class ComicListViewModel @Inject constructor(private val comicUseCase: ComicListUseCase) :
    ViewModel() {

    private val _state = MutableStateFlow(ComicListState())
    val state: StateFlow<ComicListState> = _state.asStateFlow()

    private val _effectFlow = MutableSharedFlow<ComicListEffect>()
    val effectFlow = _effectFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            collectComicItems()
        }
    }

    fun collectComicItems() {
        _state.update { state ->
            state.copy(pageState = PageState.LOADING)
        }
        viewModelScope.launch(Dispatchers.IO) {
            val items =
                comicUseCase.invoke(PAGE_SIZE, (_state.value.comicList.size / PAGE_SIZE) + 1)
            _state.update { state ->
                state.copy(
                    comicList = _state.value.comicList + items,
                    pageState = PageState.SUCCESS
                )
            }
        }
    }

    fun onEvent(event: ComicListEvent) {
        when (event) {
            is ComicListEvent.OnComicClicked -> {
                _effectFlow.tryEmit(ComicListEffect.NavigateToComicItemScreen)
            }

            is ComicListEvent.OnLoadMoreListener -> {
                collectComicItems()
            }
        }
    }

}
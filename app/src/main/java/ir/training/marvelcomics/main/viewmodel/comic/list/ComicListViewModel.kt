package ir.training.marvelcomics.main.viewmodel.comic.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.training.marvelcomics.di.IoDispatcher
import ir.training.marvelcomics.di.MainDispatcher
import ir.training.marvelcomics.domain.usecase.comic.list.ComicListUseCase
import ir.training.marvelcomics.main.state.comic.list.ComicListState
import ir.training.marvelcomics.main.view.pages.comic.list.contract.ComicListEffect
import ir.training.marvelcomics.main.view.pages.comic.list.contract.ComicListEvent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicListViewModel @Inject constructor(
    private val comicUseCase: ComicListUseCase,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _state =
        MutableStateFlow(ComicListState())
    val state: StateFlow<ComicListState> = _state.asStateFlow()

    private val _effectFlow = MutableSharedFlow<ComicListEffect>(replay = 1)
    val effectFlow = _effectFlow.asSharedFlow()

    init {
        collectComicItems()
    }

    private fun collectComicItems() {
        viewModelScope.launch(ioDispatcher) {
            comicUseCase.invoke().cachedIn(viewModelScope).catch { e ->
                Log.e("ComicListContent", "Error: ${e.message}")
            }.let { comicList ->
                _state.update { state ->
                    state.copy(
                        comicList = comicList,
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun onEvent(event: ComicListEvent) {
        when (event) {
            is ComicListEvent.OnComicClicked -> {
                _effectFlow.tryEmit(ComicListEffect.NavigateToComicItemScreen(event.comicItem))
                _effectFlow.resetReplayCache()
            }
        }
    }

}
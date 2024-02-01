package ir.training.marvelcomics.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.training.marvelcomics.domain.usecase.comic.list.ComicListUseCase
import ir.training.marvelcomics.main.state.ComicListState
import ir.training.marvelcomics.main.view.list.contract.ComicListEffect
import ir.training.marvelcomics.main.view.list.contract.ComicListEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicListViewModel @Inject constructor(private val comicUseCase: ComicListUseCase) :
    ViewModel() {

    var currentPage = MutableStateFlow(1)

    private val _state = MutableStateFlow(ComicListState())
    val state: StateFlow<ComicListState> = _state.asStateFlow()

    private val _effectFlow = MutableSharedFlow<ComicListEffect>()
    val effectFlow = _effectFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            collectComicItems()
        }
    }

    suspend fun collectComicItems() {
        GlobalScope.launch(Dispatchers.IO) {
            val items = comicUseCase.invoke(20, _state.value.page)
            _state.update { state ->
                state.copy(comicList = _state.value.comicList + items, page = _state.value.page + 1)
            }
        }
//        Pager(
//            config = PagingConfig(pageSize = 10, prefetchDistance = 2),
//            pagingSourceFactory = {
//                comicPagingSource
//            }
//        ).flow
//        Pager(
//            config = PagingConfig(pageSize = 10, prefetchDistance = 2),
//            pagingSourceFactory = { comicPagingSource }
//        ).flow.collect { pagingData ->
//            _state.value = _state.value.copy(comicList = pagingData)
//            _state.update { state ->
//                state.copy(comicList = pagingData)
//            }
//        }
    }

    fun onEvent(event: ComicListEvent) {
        when (event) {
            is ComicListEvent.OnComicClicked -> {
                _effectFlow.tryEmit(ComicListEffect.NavigateToComicItemScreen)
            }

            is ComicListEvent.OnLoadMoreListener -> {
                viewModelScope.launch {
                    collectComicItems()
                }
//                updatePage(_state.value.page)
            }
        }
    }

    fun updatePage(newPage: Int) {
        currentPage.value = newPage
    }
}
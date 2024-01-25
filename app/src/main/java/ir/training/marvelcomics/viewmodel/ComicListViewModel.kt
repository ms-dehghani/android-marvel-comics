package ir.training.marvelcomics.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.training.marvelcomics.domain.usecase.comic.list.ComicListUseCase
import ir.training.marvelcomics.state.ComicListState
import ir.training.marvelcomics.view.list.ComicListEffect
import ir.training.marvelcomics.view.list.ComicListEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class ComicListViewModel @Inject constructor(private val comicListUseCase: ComicListUseCase) :
    ViewModel() {

    var currentPage = MutableStateFlow(1)

    private val _state = MutableStateFlow(ComicListState())
    val state: StateFlow<ComicListState> = _state.asStateFlow()

    private val _efectFlow = MutableSharedFlow<ComicListEffect>(1)
    val efectFlow = _efectFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            collectComicItems()
        }
    }

    suspend fun collectComicItems() {
        comicListUseCase(currentPage.value).collect { pagingData ->
            _state.value = _state.value.copy(comicList = pagingData)
            _state.update { state ->
                state.copy(comicList = pagingData)
            }
        }
    }

    fun onEvent(event: ComicListEvent) {
        when (event) {
            is ComicListEvent.OnComicClicked -> {
                viewModelScope.launch {}
            }

            is ComicListEvent.OnLoadMoreButtonClicked -> {
                updatePage(_state.value.page)
            }
        }
    }

    fun updatePage(newPage: Int) {
        currentPage.value = newPage
    }
}
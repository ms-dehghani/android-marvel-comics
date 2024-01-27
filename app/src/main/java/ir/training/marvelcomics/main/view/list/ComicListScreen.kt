package ir.training.marvelcomics.main.view.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import ir.training.marvelcomics.main.state.ComicListState
import ir.training.marvelcomics.main.viewmodel.ComicListViewModel

@Composable
fun ComicListScreen(onComicClicked: () -> Unit) {

    val viewModel: ComicListViewModel = viewModel()
    val state: ComicListState by viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.effectFlow.collect { effect ->
            when (effect) {
                is ComicListEffect.NavigateToComicItemScreen -> {
                    onComicClicked()
                }
            }
        }
    }
    ComicListContent(comicItems = state.comicList.collectAsLazyPagingItems(),
        onLoadMoreButtonClicked = { viewModel.onEvent(ComicListEvent.OnLoadMoreButtonClicked) },
        onComicClicked = { viewModel.onEvent(ComicListEvent.OnComicClicked(it)) })
}

@Composable
fun <T : Any> PagingData<T>.collectAsLazyPagingItems(): LazyPagingItems<T> {
    return collectAsLazyPagingItems()
}
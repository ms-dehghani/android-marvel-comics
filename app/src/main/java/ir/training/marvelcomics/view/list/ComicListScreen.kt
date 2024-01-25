package ir.training.marvelcomics.view.list

import androidx.compose.runtime.Composable
import androidx.paging.PagingData
import ir.training.marvelcomics.viewmodel.ComicListViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.paging.compose.LazyPagingItems
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.training.marvelcomics.state.ComicListState

@Composable
fun ComicListScreen(viewModel: ComicListViewModel = viewModel()) {

    val state: ComicListState by viewModel.state.collectAsState()
    ComicListContent(
        comicItems = state.comicList.collectAsLazyPagingItems(),
        { viewModel.onEvent(ComicListEvent.OnLoadMoreButtonClicked) })
}

@Composable
fun <T : Any> PagingData<T>.collectAsLazyPagingItems(): LazyPagingItems<T> {
    return collectAsLazyPagingItems()
}
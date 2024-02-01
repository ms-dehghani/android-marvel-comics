package ir.training.marvelcomics.main.view.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import ir.training.marvelcomics.main.state.ComicListState
import ir.training.marvelcomics.main.view.list.contract.ComicListEvent
import ir.training.marvelcomics.main.viewmodel.ComicListViewModel

@Composable
fun ComicListScreen(onComicClicked: () -> Unit) {

    val viewModel: ComicListViewModel = hiltViewModel()
    val state: ComicListState by viewModel.state.collectAsState()

    ComicListContent(comicItems = state.comicList,
        onLoadMoreListener = { viewModel.onEvent(ComicListEvent.OnLoadMoreListener) },
        onComicClicked = { viewModel.onEvent(ComicListEvent.OnComicClicked(it)) })
}
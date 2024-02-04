package ir.training.marvelcomics.main.view.pages.comic.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import ir.training.marvelcomics.main.state.comic.list.ComicListState
import ir.training.marvelcomics.main.viewmodel.comic.list.ComicListViewModel

@Composable
fun ComicListScreen(onComicClicked: () -> Unit) {

    val viewModel: ComicListViewModel = hiltViewModel()
    val state: ComicListState by viewModel.state.collectAsState()

    ComicListContent(comicItems = state.comicList,
        onComicClicked = { onComicClicked() })
}
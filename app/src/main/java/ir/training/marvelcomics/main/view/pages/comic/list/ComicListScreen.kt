package ir.training.marvelcomics.main.view.pages.comic.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import ir.training.marvelcomics.main.state.comic.list.ComicListState
import ir.training.marvelcomics.main.view.pages.comic.list.contract.ComicListEffect
import ir.training.marvelcomics.main.view.pages.comic.list.contract.ComicListEvent
import ir.training.marvelcomics.main.viewmodel.comic.list.ComicListViewModel

@Composable
fun ComicListScreen(onComicClicked: (id: Int) -> Unit) {

    val viewModel: ComicListViewModel = hiltViewModel()

    LaunchedEffect(viewModel) {
        viewModel.effectFlow.collect { event ->
            when (event) {
                is ComicListEffect.NavigateToComicItemScreen -> {
                    onComicClicked.invoke(event.comicItem.id)
                }
            }
        }
    }

    val state: ComicListState by viewModel.state.collectAsState()
    ComicListContent(comicItems = state.comicList,
        onComicClicked = { viewModel.onEvent(event = ComicListEvent.OnComicClicked(it)) })
}
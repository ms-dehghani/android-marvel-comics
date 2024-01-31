package ir.training.marvelcomics.main.view.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.training.marvelcomics.main.view.detail.contract.ComicItemEffect
import ir.training.marvelcomics.main.view.detail.contract.ComicItemEvent
import ir.training.marvelcomics.main.viewmodel.ComicItemViewModel

@Composable
fun ComicItemScreen(onBackButtonClicked: () -> Unit) {
    val viewModel: ComicItemViewModel = viewModel()
    val comic by viewModel.comic.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.effectFlow.collect { effect ->
            when (effect) {
                is ComicItemEffect.NavigateToComicListScreen -> {
                    onBackButtonClicked()
                }
            }
        }
    }
    ComicItemContent(comic!!) {
        viewModel.onEvent(ComicItemEvent.OnBackButtonClicked)
    }
}

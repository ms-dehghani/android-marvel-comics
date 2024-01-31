package ir.training.marvelcomics.main.view.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.training.marvelcomics.main.view.item.contract.ComicItemEffect
import ir.training.marvelcomics.main.view.item.contract.ComicItemEvent
import ir.training.marvelcomics.main.viewmodel.ComicItemViewModel

@Composable
fun ComicItemScreen(onBackButtonClicked: () -> Unit) {
    val viewModel: ComicItemViewModel = viewModel()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.effectFlow.collect { effect ->
            when (effect) {
                is ComicItemEffect.NavigateToComicListScreen -> {
                    onBackButtonClicked()
                }
            }
        }
    }
    ComicItemContent(
        comic = state.comic,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        viewModel.onEvent(ComicItemEvent.OnBackButtonClicked)
    }
}

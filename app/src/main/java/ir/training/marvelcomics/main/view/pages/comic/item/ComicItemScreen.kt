package ir.training.marvelcomics.main.view.pages.comic.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ir.training.marvelcomics.main.view.pages.comic.item.contract.ComicItemEffect
import ir.training.marvelcomics.main.view.pages.comic.item.contract.ComicItemEvent
import ir.training.marvelcomics.main.viewmodel.comic.item.ComicItemViewModel

@Composable
fun ComicItemScreen(onBackButtonClicked: () -> Unit) {
    val viewModel: ComicItemViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    var isLoading by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(viewModel) {
        viewModel.effectFlow.collect { effect ->
            when (effect) {
                is ComicItemEffect.NavigateToComicListScreen -> {
                    onBackButtonClicked()
                }

                ComicItemEffect.OnComicItemReceived -> {
                    isLoading = false
                }
            }
        }
    }

    if (!isLoading) {
        ComicItemContent(
            comic = state.comic,
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            viewModel.onEvent(ComicItemEvent.OnBackButtonClicked)
        }
    }
}
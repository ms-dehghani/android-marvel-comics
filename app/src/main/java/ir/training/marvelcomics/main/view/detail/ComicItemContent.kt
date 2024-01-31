package ir.training.marvelcomics.main.view.detail

import androidx.compose.runtime.Composable
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.main.view.detail.components.AppBar
import ir.training.marvelcomics.main.view.detail.components.ComicItemView
import ir.training.marvelcomics.main.view.theme.MarvelComicsTheme

@Composable
fun ComicItemContent(
    comic: ComicItem,
    onBackButtonClicked: () -> Unit = {}
) {
    MarvelComicsTheme {
        AppBar(onBackButtonClicked)
        ComicItemView(comic)
    }
}

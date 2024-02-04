package ir.training.marvelcomics.main.view.pages.comic.item

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.main.theme.MarvelComicsTheme
import ir.training.marvelcomics.main.view.widgets.item.AppBar
import ir.training.marvelcomics.main.view.widgets.item.ComicItemView

@Composable
fun ComicItemContent(
    comic: ComicItem?,
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit = {},
) {
    MarvelComicsTheme {
        Box(modifier = modifier) {
            ComicItemView(
                comic = comic, modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxSize()
            )
            AppBar(
                onBackButtonClicked = onBackButtonClicked,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}
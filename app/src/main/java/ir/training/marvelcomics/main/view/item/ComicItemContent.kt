package ir.training.marvelcomics.main.view.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.main.view.item.components.AppBar
import ir.training.marvelcomics.main.view.item.components.ComicItemView
import ir.training.marvelcomics.main.view.theme.MarvelComicsTheme

@Composable
fun ComicItemContent(
    comic: ComicItem?,
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit = {},
) {
    MarvelComicsTheme {
        Column(modifier = modifier) {
            AppBar(
                onBackButtonClicked = onBackButtonClicked, modifier = Modifier.fillMaxWidth()
            )
            ComicItemView(
                comic = comic,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        }
    }
}

package ir.training.marvelcomics.item

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.main.view.detail.components.AppBar
import ir.training.marvelcomics.main.view.detail.components.ComicItemView
import ir.training.marvelcomics.main.view.theme.MarvelComicsTheme

@Preview
@Composable
fun ComicItemContentPreview() {
    val comic = ComicItem(
        id = 1,
        title = "Batman",
        coverUrlExtension = "url1",
        coverUrlPath = "url1",
        publishedDate = "published Date1",
        writer = "Writer1",
        penciler = "Penciler1",
        description = "Description1"
    )
    MarvelComicsTheme {
        AppBar()
        ComicItemView(comic)
    }
}
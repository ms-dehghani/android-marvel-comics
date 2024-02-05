package ir.trining.marvelcomics.list.comonents

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.main.view.widgets.list.items.ComicListItem

@Preview
@Composable
fun ComicListItemPreview() {
    ComicListItem(
        comicItem = ComicItem(
            id = 123,
            title = "The Amazing Spider-Man",
            coverUrlPath = "https://example.com/spiderman.jpg",
            coverUrlExtension = "",
            publishedDate = "March 1963",
            writer = "Stan Lee",
            penciler = "Penciler",
            description = "Description"
        ),
        onComicClicked = {}
    )
}
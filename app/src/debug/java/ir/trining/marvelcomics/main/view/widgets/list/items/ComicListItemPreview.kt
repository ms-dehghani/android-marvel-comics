package ir.trining.marvelcomics.main.view.widgets.list.items

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.main.view.widgets.list.items.ComicListItem

@Preview
@Composable
fun ComicListItemPreview() {
    ComicListItem(
        comicItem = ComicItem(
            id = 1,
            title = "title",
            coverUrlPath = "",
            coverUrlExtension = "",
            publishedDate = "2024",
            writer = "writer",
            penciler = "penciler",
            description = "description"
        ),
        onComicClicked = {})
}
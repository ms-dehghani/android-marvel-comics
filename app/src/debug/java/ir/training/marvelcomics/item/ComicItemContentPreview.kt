package ir.training.marvelcomics.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.main.view.pages.comic.item.ComicItemContent

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
    ComicItemContent(
        comic = comic,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    )
}
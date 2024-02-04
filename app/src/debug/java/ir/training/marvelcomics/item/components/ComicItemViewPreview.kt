package ir.training.marvelcomics.item.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.main.view.widgets.item.ComicItemView

@Preview
@Composable
fun ComicItemViewPreview() {
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
    ComicItemView(
        comic = comic, modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
}
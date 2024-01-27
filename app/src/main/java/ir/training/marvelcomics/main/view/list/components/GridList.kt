package ir.training.marvelcomics.main.view.list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import ir.training.marvelcomics.domain.model.ComicItem

@Composable
fun GridList(
    comicItems: LazyPagingItems<ComicItem>,
    onLoadMoreButtonClicked: () -> Unit,
    onComicClicked: (id: Int) -> Unit,
    modifier: Modifier = Modifier
) {

    Column {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = modifier
        ) {
            items(comicItems.itemCount) { index ->
                val item = comicItems[index]
                if (item != null) {
                    ComicListItem(comicItem = item, onComicClicked)
                } else {
                    // Handle placeholder or loading item
                }
            }
        }
        Button(onClick = onLoadMoreButtonClicked) {
            Text(text = "Load Next Page")
        }
    }
}
package ir.training.marvelcomics.main.view.list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import ir.training.marvelcomics.domain.model.ComicItem

@Composable
fun GridList(
    comicItems: List<ComicItem>,
    onLoadMoreListener: () -> Unit,
    onComicClicked: (id: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyGridState()

    Column {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            state = listState,
            modifier = modifier
        ) {
            items(comicItems.size) { index ->
                val item = comicItems[index]
                if (item != null) {
                    ComicListItem(comicItem = item, onComicClicked)
                } else {
                    // Handle placeholder or loading item
                }
            }
        }
    }

    LaunchedEffect(
        listState.canScrollForward && comicItems.isNotEmpty()
    ) {
        onLoadMoreListener.invoke()
    }
}
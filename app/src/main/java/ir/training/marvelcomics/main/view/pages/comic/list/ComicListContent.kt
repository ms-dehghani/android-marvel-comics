package ir.training.marvelcomics.main.view.pages.comic.list

import android.util.Log
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.main.state.base.PageState
import ir.training.marvelcomics.main.view.widgets.items.ComicListItem
import ir.training.marvelcomics.main.view.widgets.list.GridListLoadMore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.count

@Composable
fun ComicListContent(
    comicItems: Flow<PagingData<ComicItem>>? = null,
    onComicClicked: (id: Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    if (comicItems == null) {
        GridListLoadMore(
            lazyVerticalGrid = {
                Text(text = "No items found!")
            },
            itemCount = 0,
            showLoading = true,
            modifier = modifier
        )
    } else {
        val lazyComicItems = comicItems.collectAsLazyPagingItems()
        val listState = rememberLazyGridState()

        GridListLoadMore(
            itemCount = lazyComicItems.itemCount,
            lazyVerticalGrid = {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    state = listState,
                    modifier = modifier
                ) {
                    items(
                        count = lazyComicItems.itemCount,
                        key = lazyComicItems.itemKey { comicItem -> comicItem.id },
                        contentType = lazyComicItems.itemContentType { "comicItem" },
                    ) { index ->
                        ComicListItem(
                            comicItem = lazyComicItems[index]!!,
                            onComicClicked = onComicClicked
                        )
                    }
                }
            },
            showLoading = lazyComicItems.loadState.prepend == LoadState.Loading
                    || lazyComicItems.loadState.append == LoadState.Loading
                    || lazyComicItems.loadState.refresh == LoadState.Loading,
            modifier = modifier
        )
    }
}
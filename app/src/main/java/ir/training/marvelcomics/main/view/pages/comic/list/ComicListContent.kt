package ir.training.marvelcomics.main.view.pages.comic.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import ir.training.marvelcomics.R
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.main.view.widgets.list.GridListLoadMore
import ir.training.marvelcomics.main.view.widgets.list.items.ComicListItem
import kotlinx.coroutines.flow.Flow

@Composable
fun ComicListContent(
    modifier: Modifier = Modifier.background(color = colorResource(id = R.color.page_background)),
    comicItems: Flow<PagingData<ComicItem>>? = null,
    onComicClicked: (id: Int) -> Unit = {}
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.comic_list_screen),
                color = colorResource(id = R.color.text_color_primary),
                fontSize = dimensionResource(id = R.dimen.font_size_large).value.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
            )
            if (comicItems == null) {
                EmptyComicList(modifier = modifier)
            } else {
                ComicList(
                    comicItems = comicItems,
                    onComicClicked = onComicClicked,
                    modifier = modifier
                )
            }
        }

    }
}

@Composable
fun EmptyComicList(modifier: Modifier) {
    GridListLoadMore(
        lazyVerticalGrid = {},
        itemCount = 0,
        showLoading = true,
        modifier = modifier
    )
}

@Composable
fun ComicList(
    comicItems: Flow<PagingData<ComicItem>>,
    onComicClicked: (id: Int) -> Unit = {},
    modifier: Modifier
) {
    val lazyComicItems = comicItems.collectAsLazyPagingItems()
    val listState = rememberLazyGridState()
    GridListLoadMore(
        itemCount = lazyComicItems.itemCount,
        lazyVerticalGrid = {
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
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

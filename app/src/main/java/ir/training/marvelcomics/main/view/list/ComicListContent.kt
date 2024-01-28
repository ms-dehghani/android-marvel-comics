package ir.training.marvelcomics.main.view.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.main.view.list.components.GridList

@Composable
fun ComicListContent(
    comicItems: LazyPagingItems<ComicItem>,
    onLoadMoreButtonClicked: () -> Unit = {},
    onComicClicked: (id: Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    GridList(comicItems, onLoadMoreButtonClicked, onComicClicked, modifier)
}
package ir.training.marvelcomics.main.view.pages.comic.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.main.state.base.PageState
import ir.training.marvelcomics.main.view.widgets.items.ComicListItem
import ir.training.marvelcomics.main.view.widgets.list.GridListLoadMore

@Composable
fun ComicListContent(
    comicItems: List<ComicItem>,
    onLoadMoreListener: () -> Unit = {},
    onComicClicked: (id: Int) -> Unit = {},
    pageState: PageState,
    modifier: Modifier = Modifier
) {

    GridListLoadMore(
        items =
        if (comicItems.isEmpty()) listOf() else
            comicItems.map { comicItem ->
                {
                    ComicListItem(comicItem = comicItem, onComicClicked)
                }
            },
        onLoadMoreListener = onLoadMoreListener,
        pageState = pageState,
        modifier = modifier
    )
}
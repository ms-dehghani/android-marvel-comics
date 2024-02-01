package ir.training.marvelcomics.main.state.comic.list

import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.main.state.base.PageState

data class ComicListState(
    val comicList: List<ComicItem> = emptyList(),
    val pageState: PageState = PageState.LOADING,
)
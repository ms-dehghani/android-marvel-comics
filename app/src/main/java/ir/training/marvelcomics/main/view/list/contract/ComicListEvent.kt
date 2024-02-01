package ir.training.marvelcomics.main.view.list.contract

sealed class ComicListEvent {

    data class OnComicClicked(val comicId: Int) : ComicListEvent()

    data object OnLoadMoreListener : ComicListEvent()

}
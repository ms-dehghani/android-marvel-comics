package ir.training.marvelcomics.view.list

sealed class ComicListEvent {

    data class OnComicClicked(val comicId: Int) : ComicListEvent()

    data object OnLoadMoreButtonClicked : ComicListEvent()

}
package ir.training.marvelcomics.main.view.list

sealed class ComicListEvent {

    data class OnComicClicked(val comicId: Int) : ComicListEvent()

    data object OnLoadMoreButtonClicked : ComicListEvent()

}
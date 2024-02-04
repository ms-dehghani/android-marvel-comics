package ir.training.marvelcomics.main.view.pages.comic.list.contract

sealed class ComicListEvent {
    data class OnComicClicked(val comicId: Int) : ComicListEvent()
}
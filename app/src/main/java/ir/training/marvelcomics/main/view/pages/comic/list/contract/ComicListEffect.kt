package ir.training.marvelcomics.main.view.pages.comic.list.contract

sealed class ComicListEffect {
    data object NavigateToComicItemScreen : ComicListEffect()
}
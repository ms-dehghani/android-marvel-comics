package ir.training.marvelcomics.main.view.pages.comic.item.contract

sealed class ComicItemEffect {
    data object OnComicItemReceived : ComicItemEffect()
    data object NavigateToComicListScreen : ComicItemEffect()
}
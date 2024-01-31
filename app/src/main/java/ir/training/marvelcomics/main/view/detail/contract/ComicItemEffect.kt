package ir.training.marvelcomics.main.view.detail.contract

sealed class ComicItemEffect {
    data object NavigateToComicListScreen : ComicItemEffect()
}
package ir.training.marvelcomics.main.view.item.contract

sealed class ComicItemEffect {
    data object NavigateToComicListScreen : ComicItemEffect()
}
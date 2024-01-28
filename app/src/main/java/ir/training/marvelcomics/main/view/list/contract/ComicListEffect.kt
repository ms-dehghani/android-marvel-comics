package ir.training.marvelcomics.main.view.list.contract

sealed class ComicListEffect {
    data object NavigateToComicItemScreen : ComicListEffect()
}
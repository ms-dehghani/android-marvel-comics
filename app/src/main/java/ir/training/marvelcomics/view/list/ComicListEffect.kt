package ir.training.marvelcomics.view.list

sealed class ComicListEffect {
    data object NavigateToComicItemScreen : ComicListEffect()
}
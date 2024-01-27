package ir.training.marvelcomics.main.view.list

sealed class ComicListEffect {
    data object NavigateToComicItemScreen : ComicListEffect()
}
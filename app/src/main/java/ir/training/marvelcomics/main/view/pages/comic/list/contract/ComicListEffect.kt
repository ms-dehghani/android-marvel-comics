package ir.training.marvelcomics.main.view.pages.comic.list.contract

import ir.training.marvelcomics.domain.model.ComicItem

sealed class ComicListEffect {
    data class NavigateToComicItemScreen(val comicItem: ComicItem) : ComicListEffect()
}
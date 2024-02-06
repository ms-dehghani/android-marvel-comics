package ir.training.marvelcomics.main.view.pages.comic.list.contract

import ir.training.marvelcomics.domain.model.ComicItem

sealed class ComicListEvent {
    data class OnComicClicked(val comicItem: ComicItem) : ComicListEvent()
}
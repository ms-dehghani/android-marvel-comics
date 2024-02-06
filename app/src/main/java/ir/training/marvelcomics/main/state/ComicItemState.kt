package ir.training.marvelcomics.main.state

import ir.training.marvelcomics.domain.model.ComicItem

data class ComicItemState(
    val comicId: Int = -1,
    val comic: ComicItem? = null,
)
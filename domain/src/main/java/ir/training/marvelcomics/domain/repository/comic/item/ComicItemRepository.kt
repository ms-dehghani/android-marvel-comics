package ir.training.marvelcomics.domain.repository.comic.item

import ir.training.marvelcomics.domain.model.ComicItem

interface ComicItemRepository {
    suspend fun getComicById(id: Int): ComicItem?
}
package ir.training.marvelcomics.data.comic.item.dataprovider

import ir.training.marvelcomics.domain.model.ComicItem

interface ComicItemDataProvider {
    suspend fun getComicItemByID(comicID: Int): ComicItem?
}
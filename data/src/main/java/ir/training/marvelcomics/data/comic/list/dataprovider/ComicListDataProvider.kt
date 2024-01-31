package ir.training.marvelcomics.data.comic.list.dataprovider

import ir.training.marvelcomics.domain.model.ComicItem

interface ComicListDataProvider {
    suspend fun getComicList(limit: Int, offset: Int): List<ComicItem>
}
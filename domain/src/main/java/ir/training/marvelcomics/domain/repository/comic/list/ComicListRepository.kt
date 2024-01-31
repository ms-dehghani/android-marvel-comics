package ir.training.marvelcomics.domain.repository.comic.list

import ir.training.marvelcomics.domain.model.ComicItem

interface ComicListRepository {
    suspend fun getComicList(limit: Int, offset: Int): List<ComicItem>
}
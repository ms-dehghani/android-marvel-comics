package ir.training.marvelcomics.data

import ir.training.marvelcomics.domain.model.ComicItem

interface ServiceRepository {

    suspend fun getComicById(id: Int): ComicItem?

    suspend fun getComicList(limit: Int, offset: Int): List<ComicItem>

}
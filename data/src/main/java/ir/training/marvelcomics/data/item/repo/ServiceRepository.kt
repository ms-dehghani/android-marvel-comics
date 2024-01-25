package ir.training.marvelcomics.data.item.repo

import ir.training.marvelcomics.domain.model.ComicItem

interface ServiceRepository {

    suspend fun getComicById(id: Int): ComicItem?

}
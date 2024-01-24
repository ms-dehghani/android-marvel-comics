package ir.training.marvelcomics.domain.repository.comic.list

import ir.training.marvelcomics.domain.model.ComicItem

interface ComicListRepository {
    suspend fun getAll(page: Int): List<ComicItem>
}
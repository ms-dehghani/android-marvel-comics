package ir.training.marvelcomics.domain.repository.cache

import ir.training.marvelcomics.domain.model.Comic

interface ComicCache {

    fun insert(comic: Comic)

    fun insert(comics: List<Comic>)

    fun getAll(page: Int): List<Comic>

    @Throws(NullPointerException::class)
    fun getComicById(comicId: Int): Comic?
}
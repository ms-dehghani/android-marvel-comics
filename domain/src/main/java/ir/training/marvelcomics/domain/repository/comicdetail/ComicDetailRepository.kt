package ir.training.marvelcomics.domain.repository.comicdetail

import ir.training.marvelcomics.domain.model.Comic

interface ComicDetailRepository {
    suspend fun getComicById(id: Int): Comic?
}
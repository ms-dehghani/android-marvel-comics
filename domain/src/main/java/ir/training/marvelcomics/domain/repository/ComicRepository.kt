package ir.training.marvelcomics.domain.repository

import ir.training.marvelcomics.domain.model.Comic

interface ComicRepository {
    suspend fun getComicById(id: Int): Comic?
}
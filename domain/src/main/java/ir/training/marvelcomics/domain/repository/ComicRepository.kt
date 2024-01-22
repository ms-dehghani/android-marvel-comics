package ir.training.marvelcomics.domain.repository

import ir.training.marvelcomics.domain.model.Comic

interface ComicRepository {
    suspend fun getNoteById(id: Int): Comic?
}
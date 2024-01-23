package ir.training.marvelcomics.domain.repository.network

import ir.training.marvelcomics.domain.model.Comic

interface ComicService {

    suspend fun getAll(
        page: Int,
    ): List<Comic>

    suspend fun getComicById(
        id: Int
    ): Comic
}
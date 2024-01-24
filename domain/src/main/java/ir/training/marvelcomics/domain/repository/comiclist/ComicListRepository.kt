package ir.training.marvelcomics.domain.repository.comiclist

import ir.training.marvelcomics.domain.model.Comic
import kotlinx.coroutines.flow.Flow

interface ComicListRepository {

    suspend fun insert(comic: Comic)

    suspend fun insertAll(comics: List<Comic>)

    fun getAll(page: Int): Flow<List<Comic>>

    suspend fun delete(comic: Comic)

    suspend fun deleteAll()

}
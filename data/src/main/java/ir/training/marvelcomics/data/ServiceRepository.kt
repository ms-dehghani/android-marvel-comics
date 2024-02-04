package ir.training.marvelcomics.data

import androidx.paging.PagingData
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.Flow

interface ServiceRepository {

    suspend fun getComicById(id: Int): ComicItem?

    suspend fun getComicList(): Flow<PagingData<ComicItem>>

}
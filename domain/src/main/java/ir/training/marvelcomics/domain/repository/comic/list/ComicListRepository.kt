package ir.training.marvelcomics.domain.repository.comic.list

import androidx.paging.PagingData
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.Flow

interface ComicListRepository {
    suspend fun getAll(page: Int): Flow<PagingData<ComicItem>>
}
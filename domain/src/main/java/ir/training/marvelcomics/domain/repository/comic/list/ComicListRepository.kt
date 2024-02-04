package ir.training.marvelcomics.domain.repository.comic.list

import androidx.paging.PagingData
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.Flow

interface ComicListRepository {
    suspend fun getComicList(): Flow<PagingData<ComicItem>>
}
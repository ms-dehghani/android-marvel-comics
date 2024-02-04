package ir.training.marvelcomics.data.service.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import ir.training.marvelcomics.data.ServiceRepository
import ir.training.marvelcomics.data.service.dto.api.comic.ComicResponseAdapterToComicItem
import ir.training.marvelcomics.data.service.dto.db.comic.ComicDbItemAdapterToComicItem
import ir.training.marvelcomics.data.service.dto.db.comic.ComicItemAdapterToComicDBbItem
import ir.training.marvelcomics.data.service.repository.api.ApiService
import ir.training.marvelcomics.data.service.repository.db.ComicDB
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class ServiceRepositoryImpl @Inject constructor(val api: ApiService, val comicDB: ComicDB) :
    ServiceRepository {
    override suspend fun getComicById(id: Int): ComicItem? {
        val dbItem = comicDB.comicDao().getComicById(id)
        if (dbItem != null)
            return ComicDbItemAdapterToComicItem().map(dbItem)

        val apiItem =
            api.getComicById(id).data.results[0]?.let {
                ComicResponseAdapterToComicItem().map(it)
            }
        if (apiItem != null) {
            ComicItemAdapterToComicDBbItem().map(apiItem).let {
                comicDB.comicDao().insert(it)
                return apiItem
            }
        }
        return null
    }

    override suspend fun getComicList(): Flow<PagingData<ComicItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            remoteMediator = ComicRemoteMediator(api, comicDB),
            pagingSourceFactory = { comicDB.comicDao().getComicList() }
        ).flow
            .map { pagingData -> pagingData.map { ComicDbItemAdapterToComicItem().map(it) } }
    }
}


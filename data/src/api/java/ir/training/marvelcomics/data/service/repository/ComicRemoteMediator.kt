package ir.training.marvelcomics.data.service.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import ir.training.marvelcomics.data.service.dto.db.comic.ComicDbItem
import ir.training.marvelcomics.data.service.dto.db.comic.ComicItemAdapterToComicDBbItem
import ir.training.marvelcomics.data.service.repository.api.ApiService
import ir.training.marvelcomics.data.service.repository.db.ComicDB
import ir.training.marvelcomics.data.service.dto.api.comic.ComicResponseAdapterToComicItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@OptIn(ExperimentalPagingApi::class)
class ComicRemoteMediator(
    private val api: ApiService,
    private val comicDB: ComicDB
) : RemoteMediator<Int, ComicDbItem>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ComicDbItem>
    ): MediatorResult {
        return withContext(Dispatchers.IO) {
            try {
                val page = when (loadType) {
                    LoadType.REFRESH -> null
                    LoadType.PREPEND -> return@withContext MediatorResult.Success(
                        endOfPaginationReached = true
                    )

                    LoadType.APPEND -> comicDB.comicDao().getLastID()
                }

                val response = api.getComicList(
                    limit = state.config.pageSize,
                    offset = page?.div(state.config.pageSize) ?: 0
                )
                val comics = response.data.results.map { ComicResponseAdapterToComicItem().map(it) }
                val dbItems = comics.map { ComicItemAdapterToComicDBbItem().map(it) }

                comicDB.comicDao().insertAll(dbItems)

                MediatorResult.Success(endOfPaginationReached = comics.isEmpty())
            } catch (exception: Exception) {
                MediatorResult.Error(exception)
            }
        }
    }
}
package ir.training.marvelcomics.data.service.repository

import ir.training.marvelcomics.data.ServiceRepository
import ir.training.marvelcomics.data.service.dto.api.comic.ComicResponseAdapterToComicItem
import ir.training.marvelcomics.data.service.dto.db.comic.ComicDbItemAdapterToComicItem
import ir.training.marvelcomics.data.service.dto.db.comic.ComicItemAdapterToComicDBbItem
import ir.training.marvelcomics.data.service.repository.api.ApiService
import ir.training.marvelcomics.data.service.repository.db.ComicDB
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

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

    override suspend fun getComicList(
        limit: Int,
        offset: Int,
        flow: MutableStateFlow<List<ComicItem>>
    ) {
        val dbItem = comicDB.comicDao().getComicList(limit, offset)
        val dbMapItems = ArrayList<ComicItem>()
        if (dbItem.isNotEmpty()) {
            dbMapItems.addAll(dbItem.map { ComicDbItemAdapterToComicItem().map(it) })
            flow.value = dbMapItems
        }
        val apiItem =
            api.getComicList(limit, offset).data.results.map {
                ComicResponseAdapterToComicItem().map(it)
            }
        if (apiItem.isNotEmpty()) {
            apiItem.map { ComicItemAdapterToComicDBbItem().map(it) }.let {
                comicDB.comicDao().insertAll(it)
            }
            val result = ArrayList<ComicItem>()
            for (item in apiItem) {
                if (!dbMapItems.contains(item))
                    result.add(item)
            }
            flow.value = result
        }
    }
}
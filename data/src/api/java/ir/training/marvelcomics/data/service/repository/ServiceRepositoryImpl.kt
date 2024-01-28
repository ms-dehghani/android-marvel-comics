package ir.training.marvelcomics.data.service.repository

import ir.training.marvelcomics.data.ServiceRepository
import ir.training.marvelcomics.data.service.dto.api.comic.ComicResponseAdapterToComicItem
import ir.training.marvelcomics.data.service.dto.db.comic.ComicDbItemAdapterToComicItem
import ir.training.marvelcomics.data.service.dto.db.comic.ComicItemAdapterToComicDBbItem
import ir.training.marvelcomics.data.service.repository.api.ApiService
import ir.training.marvelcomics.data.service.repository.db.dao.ComicDao
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ServiceRepositoryImpl @Inject constructor(val api: ApiService, val comicDao: ComicDao) :
    ServiceRepository {
    override suspend fun getComicById(id: Int, flow: MutableStateFlow<ComicItem?>) {
        val dbItem = comicDao.getComicById(id)
        if (dbItem != null)
            flow.value = ComicDbItemAdapterToComicItem().map(dbItem)

        val apiItem =
            api.getComicById(id).data.results[0]?.let {
                ComicResponseAdapterToComicItem().map(it)
            }
        if (apiItem != null) {
            ComicItemAdapterToComicDBbItem().map(apiItem).let {
                comicDao.insert(it)
                flow.value = apiItem
            }
        }
    }
}
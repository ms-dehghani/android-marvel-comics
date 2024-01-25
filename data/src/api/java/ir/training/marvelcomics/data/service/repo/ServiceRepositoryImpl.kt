package ir.training.marvelcomics.data.service.repo

import ir.training.marvelcomics.data.item.repo.ServiceRepository
import ir.training.marvelcomics.data.service.repo.api.ApiService
import ir.training.marvelcomics.data.service.dto.comic.ComicResponseAdapterToComicItem
import ir.training.marvelcomics.domain.model.ComicItem
import javax.inject.Inject

class ServiceRepositoryImpl @Inject constructor(val api: ApiService) : ServiceRepository {
    override suspend fun getComicById(id: Int): ComicItem? {
        return api.getComicById(id).data.results[0]?.let { ComicResponseAdapterToComicItem().map(it) }
    }
}
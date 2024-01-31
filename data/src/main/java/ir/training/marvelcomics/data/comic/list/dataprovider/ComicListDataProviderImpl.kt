package ir.training.marvelcomics.data.comic.list.dataprovider

import ir.training.marvelcomics.data.ServiceRepository
import ir.training.marvelcomics.domain.model.ComicItem
import javax.inject.Inject


internal class ComicListDataProviderImpl @Inject constructor(private val repository: ServiceRepository) :
    ComicListDataProvider {
    override suspend fun getComicList(
        limit: Int, offset: Int
    ): List<ComicItem> {
        return repository.getComicList(limit, offset)
    }

}
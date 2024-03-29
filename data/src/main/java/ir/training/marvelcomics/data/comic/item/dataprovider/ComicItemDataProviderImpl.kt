package ir.training.marvelcomics.data.comic.item.dataprovider

import ir.training.marvelcomics.data.ServiceRepository
import ir.training.marvelcomics.domain.model.ComicItem
import javax.inject.Inject


internal class ComicItemDataProviderImpl @Inject constructor(private val repository: ServiceRepository) :
    ComicItemDataProvider {
    override suspend fun getComicItemByID(
        comicID: Int
    ):ComicItem? {
        return repository.getComicById(comicID)
    }

}
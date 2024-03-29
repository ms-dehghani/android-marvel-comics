package ir.training.marvelcomics.data.comic.item.repository

import ir.training.marvelcomics.data.comic.item.dataprovider.ComicItemDataProvider
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.repository.comic.item.ComicItemRepository
import javax.inject.Inject

internal class ComicItemRepositoryImpl @Inject constructor(private val dataProvider: ComicItemDataProvider) :
    ComicItemRepository {

    override suspend fun getComicById(id: Int):ComicItem? {
        return dataProvider.getComicItemByID(id)
    }

}
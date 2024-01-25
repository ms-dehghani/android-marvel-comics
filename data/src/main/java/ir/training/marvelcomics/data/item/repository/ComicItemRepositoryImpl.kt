package ir.training.marvelcomics.data.item.repository

import ir.training.marvelcomics.data.item.dataprovider.ComicItemDataProvider
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.repository.comic.item.ComicItemRepository
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

internal class ComicItemRepositoryImpl @Inject constructor(private val dataProvider: ComicItemDataProvider) :
    ComicItemRepository {

    override suspend fun getComicById(id: Int, flow: MutableStateFlow<ComicItem?>) {
        dataProvider.getComicItemByID(id, flow)
    }

}
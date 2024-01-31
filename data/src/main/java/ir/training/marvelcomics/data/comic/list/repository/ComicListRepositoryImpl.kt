package ir.training.marvelcomics.data.comic.list.repository

import ir.training.marvelcomics.data.comic.list.dataprovider.ComicListDataProvider
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.repository.comic.list.ComicListRepository
import javax.inject.Inject

internal class ComicListRepositoryImpl @Inject constructor(private val dataProvider: ComicListDataProvider) :
    ComicListRepository {

    override suspend fun getComicList(
        limit: Int,
        offset: Int
    ): List<ComicItem> {
        return dataProvider.getComicList(limit, offset)
    }

}
package ir.training.marvelcomics.data.service

import ir.training.marvelcomics.data.ServiceRepository
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.MutableStateFlow

class ServiceRepositoryImpl : ServiceRepository {
    override suspend fun getComicById(id: Int): ComicItem? {
        return ComicItem(
            id = id,
            title = "title",
            coverUrlPath = "coverUrl",
            coverUrlExtension = "",
            publishedDate = "",
            writer = "",
            penciler = "",
            description = ""
        )
    }

    override suspend fun getComicList(
        limit: Int,
        offset: Int
    ): List<ComicItem> {
        return listOf(
            ComicItem(
                id = 1,
                title = "title",
                coverUrlPath = "coverUrl",
                coverUrlExtension = "",
                publishedDate = "",
                writer = "",
                penciler = "",
                description = ""
            )
        )
    }
}
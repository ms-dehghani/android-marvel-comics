package ir.training.marvelcomics.data.service

import ir.training.marvelcomics.data.ServiceRepository
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.MutableStateFlow

class ServiceRepositoryImpl : ServiceRepository {
    override suspend fun getComicById(id: Int, flow: MutableStateFlow<ComicItem?>) {
        flow.value = ComicItem(
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
        offset: Int,
        flow: MutableStateFlow<List<ComicItem>>
    ) {
        flow.value = listOf(ComicItem(
            id = 1,
            title = "title",
            coverUrlPath = "coverUrl",
            coverUrlExtension = "",
            publishedDate = "",
            writer = "",
            penciler = "",
            description = ""
        ))
    }
}
package ir.training.marvelcomics.data.service

import ir.training.marvelcomics.data.ServiceRepository
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.MutableStateFlow

class ServiceRepositoryImpl : ServiceRepository {
    override suspend fun getComicById(id: Int, flow: MutableStateFlow<ComicItem?>) {
        flow.value = ComicItem(
            id = id,
            title = "title",
            coverUrl = "coverUrl",
            publishedDate = "",
            writer = "",
            penciler = "",
            description = ""
        )
    }
}
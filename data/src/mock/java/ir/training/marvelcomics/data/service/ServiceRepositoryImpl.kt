package ir.training.marvelcomics.data.service

import androidx.paging.PagingData
import ir.training.marvelcomics.data.ServiceRepository
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class ServiceRepositoryImpl : ServiceRepository {
    override suspend fun getComicById(id: Int): ComicItem {
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

    override suspend fun getComicList(): Flow<PagingData<ComicItem>> {
        return MutableStateFlow(
            PagingData.from(
                listOf(
                    ComicItem(
                        1,
                        "title",
                        "description",
                        "",
                        "",
                        "",
                        "",
                        ""
                    )
                )
            )
        )
    }

}
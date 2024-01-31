package ir.training.marvelcomics.data

import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.MutableStateFlow

interface ServiceRepository {

    suspend fun getComicById(id: Int): ComicItem?

    suspend fun getComicList(limit: Int,offset: Int ,flow: MutableStateFlow<List<ComicItem>>)

}
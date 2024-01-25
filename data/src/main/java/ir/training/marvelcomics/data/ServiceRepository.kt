package ir.training.marvelcomics.data

import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.MutableStateFlow

interface ServiceRepository {

    suspend fun getComicById(id: Int ,flow: MutableStateFlow<ComicItem?>)

}
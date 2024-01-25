package ir.training.marvelcomics.domain.repository.comic.item

import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.MutableStateFlow

interface ComicItemRepository {
    suspend fun getComicById(id: Int, flow: MutableStateFlow<ComicItem?>)
}
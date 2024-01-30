package ir.training.marvelcomics.domain.repository.comic.list

import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.MutableStateFlow

interface ComicListRepository {
    suspend fun getComicList(limit: Int, offset: Int, flow: MutableStateFlow<List<ComicItem>>)
}
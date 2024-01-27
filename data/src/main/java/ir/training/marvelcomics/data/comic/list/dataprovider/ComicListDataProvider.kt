package ir.training.marvelcomics.data.comic.list.dataprovider

import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.MutableStateFlow

interface ComicListDataProvider {
    suspend fun getComicList(limit: Int , offset: Int , flow: MutableStateFlow<List<ComicItem>>)
}
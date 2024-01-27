package ir.training.marvelcomics.data.comic.item.dataprovider

import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.MutableStateFlow

interface ComicItemDataProvider {
    suspend fun getComicItemByID(comicID: Int , flow: MutableStateFlow<ComicItem?>)
}
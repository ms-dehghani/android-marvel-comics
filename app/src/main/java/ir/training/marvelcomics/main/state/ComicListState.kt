package ir.training.marvelcomics.main.state

import androidx.paging.PagingData
import ir.training.marvelcomics.domain.model.ComicItem

data class ComicListState(
    val comicList: List<ComicItem> = emptyList(),
    val page: Int = 1
)
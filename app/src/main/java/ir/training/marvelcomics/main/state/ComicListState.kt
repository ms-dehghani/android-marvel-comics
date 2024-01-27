package ir.training.marvelcomics.main.state

import androidx.paging.PagingData
import ir.training.marvelcomics.domain.model.ComicItem

data class ComicListState(
    val comicList: PagingData<ComicItem> = PagingData.empty(),
    val page: Int = 1
)
package ir.training.marvelcomics.main.state.comic.list

import androidx.paging.PagingData
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.Flow

data class ComicListState(
    val comicList: Flow<PagingData<ComicItem>>? = null,
)
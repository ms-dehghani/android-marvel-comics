package ir.training.marvelcomics.domain.usecase.comic.list

import androidx.paging.PagingData
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.repository.comic.list.ComicListRepository
import kotlinx.coroutines.flow.Flow

class ComicListUseCase(private val repository: ComicListRepository) {
    suspend operator fun invoke(page: Int): Flow<PagingData<ComicItem>> {
        return repository.getAll(page)
    }
}
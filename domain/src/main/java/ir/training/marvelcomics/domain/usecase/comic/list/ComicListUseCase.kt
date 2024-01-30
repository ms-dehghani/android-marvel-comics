package ir.training.marvelcomics.domain.usecase.comic.list

import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.repository.comic.list.ComicListRepository
import kotlinx.coroutines.flow.MutableStateFlow

class ComicListUseCase(private val repository: ComicListRepository) {
    suspend operator fun invoke(limit: Int, offset: Int, flow: MutableStateFlow<List<ComicItem>>) {
        return repository.getComicList(limit = limit, offset = offset, flow = flow)
    }
}
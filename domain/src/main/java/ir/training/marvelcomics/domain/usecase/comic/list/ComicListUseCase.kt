package ir.training.marvelcomics.domain.usecase.comic.list

import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.repository.comic.list.ComicListRepository

class ComicListUseCase(private val repository: ComicListRepository) {
    suspend operator fun invoke(id: Int): List<ComicItem> {
        return repository.getAll(id)
    }
}
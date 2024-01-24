package ir.training.marvelcomics.domain.usecase.comic.item

import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.repository.comic.item.ComicItemRepository

class ComicItemUseCase(private val repository: ComicItemRepository) {
    suspend operator fun invoke(id: Int): ComicItem? {
        return repository.getComicById(id)
    }
}
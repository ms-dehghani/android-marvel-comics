package ir.training.marvelcomics.domain.usecase.comic.item

import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.repository.comic.item.ComicItemRepository
import kotlinx.coroutines.flow.MutableStateFlow

class ComicItemUseCase(private val repository: ComicItemRepository) {
    suspend operator fun invoke(id: Int, flow: MutableStateFlow<ComicItem?>) {
        repository.getComicById(id, flow)
    }
}
package ir.training.marvelcomics.domain.usecase

import ir.training.marvelcomics.domain.model.Comic
import ir.training.marvelcomics.domain.repository.ComicRepository

class GetComicUseCase(private val repository: ComicRepository) {
    suspend operator fun invoke(id: Int): Comic?{
        return repository.getNoteById(id)
    }
}
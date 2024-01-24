package ir.training.marvelcomics.domain.usecase.comicdetail

import ir.training.marvelcomics.domain.model.Comic
import ir.training.marvelcomics.domain.repository.comicdetail.ComicDetailRepository

class GetComicUseCase(private val repository: ComicDetailRepository) {
    suspend operator fun invoke(id: Int): Comic?{
        return repository.getComicById(id)
    }
}
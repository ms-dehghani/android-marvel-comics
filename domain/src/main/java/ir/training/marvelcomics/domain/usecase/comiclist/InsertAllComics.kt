package ir.training.marvelcomics.domain.usecase.comiclist

import ir.training.marvelcomics.domain.model.Comic
import ir.training.marvelcomics.domain.repository.comiclist.ComicListRepository

class InsertAllComics(
    private val comicListRepository: ComicListRepository
) {
    suspend operator fun invoke(comics: List<Comic>){
        return comicListRepository.insertAll(comics = comics)
    }
}
package ir.training.marvelcomics.domain.usecase.comiclist

import ir.training.marvelcomics.domain.model.Comic
import ir.training.marvelcomics.domain.repository.comiclist.ComicListRepository

class DeleteComic(
    private val comicListRepository: ComicListRepository
) {
    suspend operator fun invoke(comic: Comic){
        return comicListRepository.delete(comic = comic)
    }
}
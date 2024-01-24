package ir.training.marvelcomics.domain.usecase.comiclist

import ir.training.marvelcomics.domain.model.Comic
import ir.training.marvelcomics.domain.repository.comiclist.ComicListRepository

class InsertComic(
    private val comicListRepository: ComicListRepository
) {
    suspend operator fun invoke(comic: Comic){
        return comicListRepository.insert(comic = comic)
    }
}
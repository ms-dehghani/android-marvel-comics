package ir.training.marvelcomics.domain.usecase.comiclist

import ir.training.marvelcomics.domain.repository.comiclist.ComicListRepository

class DeleteAllComics(
    private val comicListRepository: ComicListRepository
) {
    suspend operator fun invoke(){
        return comicListRepository.deleteAll()
    }
}
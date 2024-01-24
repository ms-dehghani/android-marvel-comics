package ir.training.marvelcomics.domain.usecase.comiclist

import ir.training.marvelcomics.domain.model.Comic
import ir.training.marvelcomics.domain.repository.comiclist.ComicListRepository
import kotlinx.coroutines.flow.Flow

class GetAllComics(
    private val comicListRepository: ComicListRepository
) {
    operator fun invoke(page: Int): Flow<List<Comic>> {
        return comicListRepository.getAll(page = page)
    }
}
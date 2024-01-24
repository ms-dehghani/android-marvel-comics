package ir.training.marvelcomics.domain.usecase.comiclist

data class ComicListUseCase(
    val getAllComics: GetAllComics,
    val insertAllComics: InsertAllComics,
    val insertComic: InsertComic,
    val deleteAllComics: DeleteAllComics,
    val deleteComic: DeleteComic
)
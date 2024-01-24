package ir.training.marvelcomics.domain.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.training.marvelcomics.domain.repository.comiclist.ComicListRepository
import ir.training.marvelcomics.domain.usecase.comiclist.ComicListUseCase
import ir.training.marvelcomics.domain.usecase.comiclist.DeleteAllComics
import ir.training.marvelcomics.domain.usecase.comiclist.DeleteComic
import ir.training.marvelcomics.domain.usecase.comiclist.GetAllComics
import ir.training.marvelcomics.domain.usecase.comiclist.InsertAllComics
import ir.training.marvelcomics.domain.usecase.comiclist.InsertComic

@Module
@InstallIn(SingletonComponent::class)
class ComicListDIModule {
    fun provideComicListUseCase(comicListRepository: ComicListRepository) = ComicListUseCase(
        getAllComics = GetAllComics(comicListRepository),
        insertAllComics = InsertAllComics(comicListRepository),
        insertComic = InsertComic(comicListRepository),
        deleteAllComics = DeleteAllComics(comicListRepository),
        deleteComic = DeleteComic(comicListRepository),
    )
}
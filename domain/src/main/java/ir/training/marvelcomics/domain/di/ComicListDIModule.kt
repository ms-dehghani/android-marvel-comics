package ir.training.marvelcomics.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.training.marvelcomics.domain.repository.comic.list.ComicListRepository
import ir.training.marvelcomics.domain.usecase.comic.list.ComicListUseCase

@Module
@InstallIn(SingletonComponent::class)
class ComicListDIModule {
    @Provides
    fun provideComicListUseCase(comicListRepository: ComicListRepository): ComicListUseCase {
        return ComicListUseCase(comicListRepository)
    }
}
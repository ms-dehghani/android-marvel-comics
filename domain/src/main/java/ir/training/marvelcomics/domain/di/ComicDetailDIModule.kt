package ir.training.marvelcomics.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.training.marvelcomics.domain.repository.comic.item.ComicItemRepository
import ir.training.marvelcomics.domain.usecase.comic.item.ComicItemUseCase

@Module
@InstallIn(SingletonComponent::class)
class ComicDetailDIModule {
    @Provides
    fun provideComicItemUseCase(repository: ComicItemRepository): ComicItemUseCase {
        return ComicItemUseCase(repository)
    }
}
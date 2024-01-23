package ir.training.marvelcomics.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.training.marvelcomics.domain.repository.cache.ComicCache
import ir.training.marvelcomics.domain.usecase.comicdetail.GetComicUseCase

@Module
@InstallIn(SingletonComponent::class)
class ComicDetailDIModule {
    @Provides
    fun getComicUseCase(comicCache: ComicCache): GetComicUseCase {
        return GetComicUseCase(comicCache)
    }
}
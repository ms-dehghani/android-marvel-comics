package ir.training.marvelcomics.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.training.marvelcomics.domain.repository.cache.ComicCache
import ir.training.marvelcomics.domain.repository.network.ComicService
import ir.training.marvelcomics.domain.usecase.comiclist.GetAllComicUseCase

@Module
@InstallIn(SingletonComponent::class)
class ComicListDIModule {
    @Provides
    fun getAllComicUseCase(comicService: ComicService, comicCache: ComicCache): GetAllComicUseCase {
        return GetAllComicUseCase(comicService, comicCache)
    }
}
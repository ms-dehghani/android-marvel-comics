package ir.training.marvelcomics.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.training.marvelcomics.domain.repository.comicdetail.ComicDetailRepository
import ir.training.marvelcomics.domain.usecase.comicdetail.GetComicUseCase

@Module
@InstallIn(SingletonComponent::class)
class ComicDetailDIModule {
    @Provides
    fun getComicUseCase(repository: ComicDetailRepository): GetComicUseCase {
        return GetComicUseCase(repository)
    }
}
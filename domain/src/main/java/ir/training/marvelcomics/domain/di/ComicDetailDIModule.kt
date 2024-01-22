package ir.training.marvelcomics.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import ir.training.marvelcomics.domain.repository.ComicRepository
import ir.training.marvelcomics.domain.usecase.GetComicUseCase

@Module
@InstallIn
class ComicDetailDIModule {
    @Provides
    fun getComicUseCase(repository: ComicRepository): GetComicUseCase {
        return GetComicUseCase(repository)
    }
}
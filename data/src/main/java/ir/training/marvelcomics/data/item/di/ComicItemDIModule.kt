package ir.training.marvelcomics.data.item.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.training.marvelcomics.data.item.dataprovider.ComicItemDataProvider
import ir.training.marvelcomics.data.item.dataprovider.ComicItemDataProviderImpl
import ir.training.marvelcomics.data.item.repo.ComicItemRepositoryImpl
import ir.training.marvelcomics.data.item.repo.ServiceRepository
import ir.training.marvelcomics.domain.repository.comic.item.ComicItemRepository

@Module
@InstallIn(SingletonComponent::class)
internal class ComicItemDIModule {

    @Provides
    fun provideDataProvider(repo: ServiceRepository): ComicItemDataProvider {
        return ComicItemDataProviderImpl(repo)
    }

    @Provides
    fun provideRepository(dataProvider: ComicItemDataProvider): ComicItemRepository {
        return ComicItemRepositoryImpl(dataProvider)
    }

}
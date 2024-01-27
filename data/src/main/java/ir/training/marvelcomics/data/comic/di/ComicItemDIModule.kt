package ir.training.marvelcomics.data.comic.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.training.marvelcomics.data.ServiceRepository
import ir.training.marvelcomics.data.comic.item.dataprovider.ComicItemDataProvider
import ir.training.marvelcomics.data.comic.item.dataprovider.ComicItemDataProviderImpl
import ir.training.marvelcomics.data.comic.item.repository.ComicItemRepositoryImpl
import ir.training.marvelcomics.data.comic.list.dataprovider.ComicListDataProvider
import ir.training.marvelcomics.data.comic.list.dataprovider.ComicListDataProviderImpl
import ir.training.marvelcomics.data.comic.list.repository.ComicListRepositoryImpl
import ir.training.marvelcomics.domain.repository.comic.item.ComicItemRepository
import ir.training.marvelcomics.domain.repository.comic.list.ComicListRepository

@Module
@InstallIn(SingletonComponent::class)
internal class ComicItemDIModule {

    @Provides
    fun provideItemDataProvider(repo: ServiceRepository): ComicItemDataProvider {
        return ComicItemDataProviderImpl(repo)
    }

    @Provides
    fun provideItemRepository(dataProvider: ComicItemDataProvider): ComicItemRepository {
        return ComicItemRepositoryImpl(dataProvider)
    }


    @Provides
    fun provideListDataProvider(repo: ServiceRepository): ComicListDataProvider {
        return ComicListDataProviderImpl(repo)
    }

    @Provides
    fun provideListRepository(dataProvider: ComicListDataProvider): ComicListRepository {
        return ComicListRepositoryImpl(dataProvider)
    }


}
package ir.training.marvelcomics.data.comic.list.dataprovider

import androidx.paging.PagingData
import ir.training.marvelcomics.data.ServiceRepository
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


internal class ComicListDataProviderImpl @Inject constructor(private val repository: ServiceRepository) :
    ComicListDataProvider {
    override suspend fun getComicList(): Flow<PagingData<ComicItem>> {
        return repository.getComicList()
    }

}
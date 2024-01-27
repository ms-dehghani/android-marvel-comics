package ir.training.marvelcomics.data.comic.list.dataprovider

import ir.training.marvelcomics.data.ServiceRepository
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


internal class ComicListDataProviderImpl @Inject constructor(private val repository: ServiceRepository) :
    ComicListDataProvider {
    override suspend fun getComicList(
        limit: Int, offset: Int, flow: MutableStateFlow<List<ComicItem>>
    ) {
        repository.getComicList(limit , offset, flow)
    }

}
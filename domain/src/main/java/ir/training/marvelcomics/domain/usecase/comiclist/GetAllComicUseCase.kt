package ir.training.marvelcomics.domain.usecase.comiclist

import ir.training.marvelcomics.domain.model.Comic
import ir.training.marvelcomics.domain.model.GenericMessageInfo
import ir.training.marvelcomics.domain.repository.cache.ComicCache
import ir.training.marvelcomics.domain.repository.network.ComicService
import ir.training.marvelcomics.domain.util.DataState
import ir.training.marvelcomics.domain.util.UIComponentType
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllComicUseCase(
    private val comicService: ComicService,
    private val comicCache: ComicCache,
) {

    fun invoke(page: Int): Flow<DataState<List<Comic>>> = flow {
        try {
            emit(DataState.loading())

            delay(500)

            val recipes = comicService.getAll(
                page = page,
            )
            comicCache.insert(recipes)

            val cacheResult = comicCache.getAll(page = page)

            emit(DataState.data(message = null, data = cacheResult))

        } catch (e: Exception) {
            emit(
                DataState.error(
                    message = GenericMessageInfo.Builder().id("Comics.Error").title("Error")
                        .uiComponentType(UIComponentType.Dialog)
                        .description(e.message ?: "Unknown Error")
                )
            )
        }
    }
}
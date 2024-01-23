package ir.training.marvelcomics.domain.usecase.comicdetail

import ir.training.marvelcomics.domain.model.Comic
import ir.training.marvelcomics.domain.model.GenericMessageInfo
import ir.training.marvelcomics.domain.repository.cache.ComicCache
import ir.training.marvelcomics.domain.util.DataState
import ir.training.marvelcomics.domain.util.UIComponentType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetComicUseCase(
    private val comicCache: ComicCache,
) {
    fun invoke(
        comicId: Int,
    ): Flow<DataState<Comic>> = flow {
        try {
            emit(DataState.loading())

            // Force error for testing
            if (comicId == -1) {
                throw Exception("Invalid Comic Id")
            }

            val comic = comicCache.getComicById(comicId)

            emit(DataState.data(message = null, data = comic))

        } catch (e: Exception) {
            emit(
                DataState.error<Comic>(
                    message = GenericMessageInfo.Builder().id("GetComic.Error").title("Error")
                        .uiComponentType(UIComponentType.Dialog)
                        .description(e.message ?: "Unknown Error")
                )
            )
        }
    }
}

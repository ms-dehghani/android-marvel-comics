package ir.training.marvelcomics.domain.usecase.comiclist

import io.mockk.coEvery
import io.mockk.mockk
import ir.training.marvelcomics.domain.model.Comic
import ir.training.marvelcomics.domain.repository.cache.ComicCache
import ir.training.marvelcomics.domain.repository.network.ComicService
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import io.mockk.coVerify
import ir.training.marvelcomics.domain.model.GenericMessageInfo
import ir.training.marvelcomics.domain.util.DataState
import ir.training.marvelcomics.domain.util.UIComponentType
import kotlinx.coroutines.runBlocking

internal class GetAllComicUseCaseTest {

    private val comicService: ComicService = mockk()
    private val comicCache: ComicCache = mockk()
    private val getAllComicUseCase = GetAllComicUseCase(comicService, comicCache)

    @Test
    fun givenPageNumber_WhenGetAllComicUseCaseInvoked_ThenExpectedComicsListReturnedAndCached() = runBlocking {
        // Given
        val page = 1
        val comics = listOf(
            Comic(
                id = 1,
                title = "Batman",
                coverUrl = "url1",
                publishedDate = "published Date1",
                writer = "Writer1",
                penciler = "Penciler1",
                description = "Description1"
            ),
            Comic( id = 2,
                title = "Superman",
                coverUrl = "url2",
                publishedDate = "published Date2",
                writer = "Writer2",
                penciler = "Penciler2",
                description = "Description2")
        )
        val loadingState = DataState.loading<List<Comic>>()
        val dataState = DataState.data(message = null, data = comics)
        val errorState = DataState.error<Comic>(
            message = GenericMessageInfo.Builder().id("SearchRecipes.Error").title("Error")
                .uiComponentType(UIComponentType.Dialog)
                .description("Network Error")
        )

        coEvery { comicService.getAll(page) } returns comics
        coEvery { comicCache.insert(comics) } returns Unit
        coEvery { comicCache.getAll(page) } returns comics
        coEvery { comicService.getAll(page + 1) } throws Exception("Network Error")

        // When
        val flow = getAllComicUseCase.invoke(page)

        // Then
        val expectedStates = listOf(loadingState, dataState, errorState)
        var index = 0
        flow.collect { state ->
            assertEquals(expectedStates[index], state)
            index++
        }

        // Verify
        coVerify { comicService.getAll(page) }
        coVerify { comicCache.insert(comics) }
        coVerify { comicCache.getAll(page) }
    }
}


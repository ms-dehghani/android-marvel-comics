package ir.training.marvelcomics.domain.usecase.comicdetail

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import ir.training.marvelcomics.domain.model.Comic
import ir.training.marvelcomics.domain.model.GenericMessageInfo
import ir.training.marvelcomics.domain.repository.cache.ComicCache
import ir.training.marvelcomics.domain.util.DataState
import ir.training.marvelcomics.domain.util.UIComponentType
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.Test

internal class GetComicUseCaseTest {

    private val comicCache: ComicCache = mockk()
    private val getComicUseCase = GetComicUseCase(comicCache)

    @Test
    fun givenValidComicId_WhenGetComicUseCaseInvoked_ThenReturnedStatesAreLoadingAndExpectedData() = runBlocking {
        // Given
        val comicId = 2
        val comic = Comic( id = comicId,
            title = "Superman",
            coverUrl = "url2",
            publishedDate = "published Date2",
            writer = "Writer2",
            penciler = "Penciler2",
            description = "Description2")
        val loadingState = DataState.loading<Comic>()
        val dataState = DataState.data(message = null, data = comic)

        coEvery { comicCache.getComicById(comicId) } returns comic

        // When
        val flow = getComicUseCase.invoke(comicId)

        // Then
        val expectedStates = listOf(loadingState, dataState)
        var index = 0
        flow.collect { state ->
            assertEquals(expectedStates[index], state)
            index++
        }

        // Verify
        coVerify { comicCache.getComicById(comicId) }
    }

    @Test
    fun givenInvalidComicId_WhenGetComicUseCaseInvoked_ThenReturnedStateIsError() = runBlocking {
        // Given
        val comicId = -1
        val loadingState = DataState.loading<Comic>()
        val errorState = DataState.error<Comic>(
            message = GenericMessageInfo.Builder().id("GetComic.Error").title("Error")
                .uiComponentType(UIComponentType.Dialog)
                .description("Invalid Comic Id")
        )

        coEvery { comicCache.getComicById(comicId) } throws Exception("Invalid Comic Id")

        // When
        val flow = getComicUseCase.invoke(comicId)

        // Then
        val expectedStates = listOf(loadingState, errorState)
        var index = 0
        flow.collect { state ->
            assertEquals(expectedStates[index].message?.id, state.message?.id)
            assertEquals(expectedStates[index].message?.title, state.message?.title)
            assertEquals(expectedStates[index].message?.description, state.message?.description)
            index++
        }
    }
}
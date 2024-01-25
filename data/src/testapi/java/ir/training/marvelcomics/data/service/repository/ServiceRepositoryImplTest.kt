package ir.training.marvelcomics.data.service.repository

import app.cash.turbine.test
import io.mockk.coEvery
import io.mockk.mockk
import ir.training.marvelcomics.data.service.dto.api.base.BaseResponse
import ir.training.marvelcomics.data.service.dto.api.base.DataResponse
import ir.training.marvelcomics.data.service.dto.api.comic.ComicResponse
import ir.training.marvelcomics.data.service.dto.api.thumbnail.ThumbnailResponse
import ir.training.marvelcomics.data.service.repository.api.ApiService
import ir.training.marvelcomics.data.service.repository.db.dao.ComicDao
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test


class ServiceRepositoryImplTest {

    @Test
    fun givenComicID_WhenGetComicByIdInvoked_ThenExpectedComicsItemReturned() = runBlocking {
        // Given
        val mockApiService = mockk<ApiService>()
        val mockDBService = mockk<ComicDao>()
        val serviceRepository = ServiceRepositoryImpl(mockApiService, mockDBService)

        val expectedComicItem = ComicItem(
            id = 1, title = "title", coverUrl = "imageUrl.", publishedDate = "", writer = "",
            penciler = "", description = "description"
        )
        val comicResponse = ComicResponse(
            id = 1, title = "title", description = "description",
            thumbnail = ThumbnailResponse(
                extension = "",
                path = "imageUrl"
            )
        )

        val baseResponse = BaseResponse<ComicResponse?>(
            attributionHTML = "",
            attributionText = "",
            code = 200,
            copyright = "OK",
            data = DataResponse(1, 1, 1, listOf(comicResponse), 1),
            status = "Ok",
        )

        coEvery { mockDBService.getComicById(any()) } returns null
        coEvery { mockDBService.insert(any()) } returns Unit
        coEvery { mockApiService.getComicById(any()) } returns baseResponse

        // When
        val mutableStateFlow = MutableStateFlow<ComicItem?>(null)
        mutableStateFlow.test {
            assertEquals(null, awaitItem())
            serviceRepository.getComicById(1, mutableStateFlow)
            assertEquals(expectedComicItem, awaitItem())
            assertEquals(cancelAndConsumeRemainingEvents().size, 0)
        }
    }


    @Test
    fun givenComicID_WhenGetComicByIdInvoked_ThenNullReturned() = runBlocking {
        // Given
        val mockApiService = mockk<ApiService>()
        val mockDBService = mockk<ComicDao>()
        val serviceRepository = ServiceRepositoryImpl(mockApiService, mockDBService)

        val baseResponse = BaseResponse<ComicResponse?>(
            attributionHTML = "",
            attributionText = "",
            code = 200,
            copyright = "OK",
            data = DataResponse(1, 1, 1, listOf(null), 1),
            status = "Ok",
        )

        coEvery { mockDBService.getComicById(any()) } returns null
        coEvery { mockApiService.getComicById(any()) } returns baseResponse

        // When
        val mutableStateFlow = MutableStateFlow<ComicItem?>(null)
        mutableStateFlow.test {
            assertEquals(null, awaitItem())
            serviceRepository.getComicById(1, mutableStateFlow)
            assertEquals(cancelAndConsumeRemainingEvents().size, 0)
        }
    }
}
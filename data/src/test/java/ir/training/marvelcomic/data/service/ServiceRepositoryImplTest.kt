package ir.training.marvelcomic.data.service

import io.mockk.coEvery
import io.mockk.mockk
import ir.training.marvelcomics.data.service.dto.base.BaseResponse
import ir.training.marvelcomics.data.service.dto.base.DataResponse
import ir.training.marvelcomics.data.service.repository.ServiceRepositoryImpl
import ir.training.marvelcomics.data.service.repository.api.ApiService
import ir.training.marvelcomics.data.service.dto.comic.ComicResponse
import ir.training.marvelcomics.data.service.dto.thumbnail.ThumbnailResponse
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class ServiceRepositoryImplTest {

    @Test
    fun givenComicID_WhenGetComicByIdInvoked_ThenExpectedComicsItemReturned() = runBlocking {
        // Given
        val mockApiService = mockk<ApiService>()
        val serviceRepository = ServiceRepositoryImpl(mockApiService)
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

        coEvery { mockApiService.getComicById(any()) } returns baseResponse

        // When
        val actualComicItem = serviceRepository.getComicById(1)

        // Then
        assertEquals(expectedComicItem, actualComicItem)
    }


    @Test
    fun givenComicID_WhenGetComicByIdInvoked_ThenNullReturned() = runBlocking {
        // Given
        val mockApiService = mockk<ApiService>()
        val serviceRepository = ServiceRepositoryImpl(mockApiService)

        val baseResponse = BaseResponse<ComicResponse?>(
            attributionHTML = "",
            attributionText = "",
            code = 200,
            copyright = "OK",
            data = DataResponse(1, 1, 1, listOf(null), 1),
            status = "Ok",
        )

        coEvery { mockApiService.getComicById(any()) } returns baseResponse

        // When
        val actualComicItem = serviceRepository.getComicById(1)

        // Then
        assertEquals(actualComicItem, null)
    }
}
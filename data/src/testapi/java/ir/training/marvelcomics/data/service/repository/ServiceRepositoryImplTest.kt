package ir.training.marvelcomics.data.service.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import ir.training.marvelcomics.data.service.dto.api.base.BaseResponse
import ir.training.marvelcomics.data.service.dto.api.base.DataResponse
import ir.training.marvelcomics.data.service.dto.api.comic.ComicResponse
import ir.training.marvelcomics.data.service.dto.api.creators.CreatorItem
import ir.training.marvelcomics.data.service.dto.api.creators.CreatorsResponse
import ir.training.marvelcomics.data.service.dto.api.thumbnail.ThumbnailResponse
import ir.training.marvelcomics.data.service.repository.api.ApiService
import ir.training.marvelcomics.data.service.repository.db.ComicDB
import ir.training.marvelcomics.data.service.repository.db.dao.ComicDao
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test


class ServiceRepositoryImplTest {

    @Test
    fun givenComicID_WhenGetComicByIdInvoked_ThenExpectedComicsItemReturned() = runBlocking {
        // Given
        val mockApiService = mockk<ApiService>()
        val mockDBService = mockk<ComicDao>()
        val mockDB = mockk<ComicDB>()

        val serviceRepository = ServiceRepositoryImpl(mockApiService, mockDB)

        val expectedComicItem = ComicItem(
            id = 1,
            title = "title",
            coverUrlPath = "imageUrl",
            coverUrlExtension = "",
            publishedDate = "",
            writer = "",
            penciler = "",
            description = "description"
        )
        val comicResponse = ComicResponse(
            id = 1, title = "title", description = "description",
            modified = "",
            thumbnail = ThumbnailResponse(
                extension = "",
                path = "imageUrl"
            ),
            creators = CreatorsResponse("" , listOf(
                CreatorItem("", ""),
                CreatorItem("", ""),
            ))
        )

        val baseResponse = BaseResponse<ComicResponse?>(
            attributionHTML = "",
            attributionText = "",
            code = 200,
            copyright = "OK",
            data = DataResponse(1, 1, 1, listOf(comicResponse), 1),
            status = "Ok",
        )

        every { mockDB.comicDao() } returns mockDBService

        coEvery { mockDBService.getComicById(any()) } returns null
        coEvery { mockDBService.insert(any()) } returns Unit
        coEvery { mockApiService.getComicById(any()) } returns baseResponse

        val item = serviceRepository.getComicById(1)
        assertEquals(expectedComicItem, item)
    }


    @Test
    fun givenComicID_WhenGetComicByIdInvoked_ThenNullReturned() = runBlocking {
        // Given
        val mockApiService = mockk<ApiService>()
        val mockDBService = mockk<ComicDao>()
        val mockDB = mockk<ComicDB>()
        val serviceRepository = ServiceRepositoryImpl(mockApiService, mockDB)

        val baseResponse = BaseResponse<ComicResponse?>(
            attributionHTML = "",
            attributionText = "",
            code = 200,
            copyright = "OK",
            data = DataResponse(1, 1, 1, listOf(null), 1),
            status = "Ok",
        )

        every { mockDB.comicDao() } returns mockDBService

        coEvery { mockDBService.getComicById(any()) } returns null
        coEvery { mockApiService.getComicById(any()) } returns baseResponse

        // When
        val item = serviceRepository.getComicById(1)
        assertEquals(null, item)
    }

    @Test
    fun givenPagingSource_WhenLoadInvoked_ThenExpectedComicListReturned() = runBlocking {
        // Given
        val expectedComicList = listOf(
            ComicItem(
                id = 1,
                title = "title1",
                coverUrlPath = "imageUrl1",
                coverUrlExtension = "",
                publishedDate = "",
                writer = "",
                penciler = "",
                description = "description1"
            ),
            ComicItem(
                id = 2,
                title = "title2",
                coverUrlPath = "imageUrl2",
                coverUrlExtension = "",
                publishedDate = "",
                writer = "",
                penciler = "",
                description = "description2"
            )
        )

        val mockPagingSource = object : PagingSource<Int, ComicItem>() {
            override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ComicItem> {
                return LoadResult.Page(
                    data = expectedComicList,
                    prevKey = null,
                    nextKey = null
                )
            }

            override fun getRefreshKey(state: PagingState<Int, ComicItem>): Int {
                return 0
            }
        }

        // When
        val result = mockPagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 2,
                placeholdersEnabled = false
            )
        )

        // Then
        if (result is PagingSource.LoadResult.Page) {
            assertEquals(expectedComicList, result.data)
        } else {
            fail("Result should be of type LoadResult.Page")
        }
    }


}
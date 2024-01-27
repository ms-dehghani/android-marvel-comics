package ir.training.marvelcomics.data.item.repository

import app.cash.turbine.test
import io.mockk.coEvery
import io.mockk.mockk
import ir.training.marvelcomics.data.item.dataprovider.ComicItemDataProvider
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.fail
import org.junit.Test

class ComicItemRepositoryImplTest {

    @Test
    fun givenComicID_WhenGetComicByIdInvoked_ThenExpectedComicsItemReturned() = runBlocking {
        // Given
        val mockDataProvider = mockk<ComicItemDataProvider>()
        val comicItemRepository = ComicItemRepositoryImpl(mockDataProvider)
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

        val mutableStateFlow = MutableStateFlow<ComicItem?>(null)


        coEvery {
            mockDataProvider.getComicItemByID(
                any(),
                mutableStateFlow
            )
        } coAnswers {
            yield()
            mutableStateFlow.update { expectedComicItem }
        }

        mutableStateFlow.test {
            assertEquals(null, awaitItem())
            comicItemRepository.getComicById(1, mutableStateFlow)
            assertEquals(expectedComicItem, awaitItem())
        }

    }

    @Test
    fun givenComicID_WhenGetComicByIdInvoked_ThenNullReturned() = runBlocking {
        val mockDataProvider = mockk<ComicItemDataProvider>()
        val comicItemRepository = ComicItemRepositoryImpl(mockDataProvider)

        val mutableStateFlow = MutableStateFlow<ComicItem?>(null)


        coEvery {
            mockDataProvider.getComicItemByID(
                any(),
                mutableStateFlow
            )
        } coAnswers {
            yield()
            mutableStateFlow.update { null }
        }

        mutableStateFlow.test {
            assertEquals(null, awaitItem())
            comicItemRepository.getComicById(1, mutableStateFlow)
        }

    }

    @Test
    fun givenComicID_WhenGetComicByIdInvoked_ThenExceptionHandled() = runBlocking {
        // Given
        val mockDataProvider = mockk<ComicItemDataProvider>()
        val comicItemRepository = ComicItemRepositoryImpl(mockDataProvider)
        val mutableStateFlow = MutableStateFlow<ComicItem?>(null)

        // When
        coEvery {
            mockDataProvider.getComicItemByID(
                any(),
                mutableStateFlow
            )
        } throws Exception("Test exception")

        // Then
        try {
            comicItemRepository.getComicById(1, mutableStateFlow)
            fail("Exception was expected but not thrown")
        } catch (e: Exception) {
            assertEquals("Test exception", e.message)
        }
    }

    @Test
    fun givenComicID_WhenGetComicByIdInvoked_ThenDifferentComicItemReturned() = runBlocking {
        // Given
        val mockDataProvider = mockk<ComicItemDataProvider>()
        val comicItemRepository = ComicItemRepositoryImpl(mockDataProvider)
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
        val differentComicItem = ComicItem(
            id = 2,
            title = "different title",
            coverUrlPath = "different imageUrl",
            coverUrlExtension = "",
            publishedDate = "",
            writer = "",
            penciler = "",
            description = "different description"
        )

        val mutableStateFlow = MutableStateFlow<ComicItem?>(null)

        // When
        coEvery {
            mockDataProvider.getComicItemByID(
                any(),
                mutableStateFlow
            )
        } coAnswers {
            yield()
            mutableStateFlow.update { differentComicItem }
        }

        // Then
        mutableStateFlow.test {
            assertEquals(null, awaitItem())
            comicItemRepository.getComicById(1, mutableStateFlow)
            var item = awaitItem()
            assertNotEquals(expectedComicItem, item)
            assertEquals(differentComicItem, item)
        }
    }

}
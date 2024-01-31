package ir.training.marvelcomics.data.comic.item.repository

import io.mockk.coEvery
import io.mockk.mockk
import ir.training.marvelcomics.data.comic.item.dataprovider.ComicItemDataProvider
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.runBlocking
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

        coEvery {
            mockDataProvider.getComicItemByID(
                any()
            )
        } returns expectedComicItem

        val item = comicItemRepository.getComicById(1)

        assertEquals(expectedComicItem, item)
    }

    @Test
    fun givenComicID_WhenGetComicByIdInvoked_ThenNullReturned() = runBlocking {
        val mockDataProvider = mockk<ComicItemDataProvider>()
        val comicItemRepository = ComicItemRepositoryImpl(mockDataProvider)

        coEvery {
            mockDataProvider.getComicItemByID(
                any()
            )
        } returns null

        val item = comicItemRepository.getComicById(1)

        assertEquals(null, item)
    }

    @Test
    fun givenComicID_WhenGetComicByIdInvoked_ThenExceptionHandled() = runBlocking {
        // Given
        val mockDataProvider = mockk<ComicItemDataProvider>()
        val comicItemRepository = ComicItemRepositoryImpl(mockDataProvider)

        // When
        coEvery {
            mockDataProvider.getComicItemByID(
                any()
            )
        } throws Exception("Test exception")

        // Then
        try {
            comicItemRepository.getComicById(1)
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

        // When
        coEvery {
            mockDataProvider.getComicItemByID(
                any()
            )
        } returns differentComicItem

        val item = comicItemRepository.getComicById(1)

        assertNotEquals(expectedComicItem, item)
        assertEquals(differentComicItem, item)
    }

}
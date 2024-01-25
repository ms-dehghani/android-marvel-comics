package ir.training.marvelcomic.data.item.repository

import io.mockk.coEvery
import io.mockk.mockk
import ir.training.marvelcomics.data.item.dataprovider.ComicItemDataProvider
import ir.training.marvelcomics.data.item.repository.ComicItemRepositoryImpl
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class ComicItemRepositoryImplTest {

    @Test
    fun givenComicID_WhenGetComicByIdInvoked_ThenExpectedComicsItemReturned() = runBlocking {
        // Given
        val mockDataProvider = mockk<ComicItemDataProvider>()
        val comicItemRepository = ComicItemRepositoryImpl(mockDataProvider)
        val expectedComicItem = ComicItem(
            1, "title", "imageUrl", "", "",
            "", "description"
        )
        coEvery { mockDataProvider.getComicItemByID(any()) } returns expectedComicItem

        // When
        val actualComicItem = comicItemRepository.getComicById(1)

        // Then
        assertEquals(expectedComicItem, actualComicItem)
    }

    @Test
    fun givenComicID_WhenGetComicByIdInvoked_ThenNullReturned() = runBlocking {
        // Given
        val mockDataProvider = mockk<ComicItemDataProvider>()
        val comicItemRepository = ComicItemRepositoryImpl(mockDataProvider)
        val expectedComicItem = null
        coEvery { mockDataProvider.getComicItemByID(any()) } returns expectedComicItem

        // When
        val actualComicItem = comicItemRepository.getComicById(1)

        // Then
        assertEquals(actualComicItem, null)
    }

}
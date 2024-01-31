package ir.training.marvelcomics.data.comic.list.repository

import io.mockk.coEvery
import io.mockk.mockk
import ir.training.marvelcomics.data.comic.list.dataprovider.ComicListDataProvider
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class ComicListRepositoryImplTest {

    @Test
    fun givenLimitAndOffset_WhenGetComicListInvoked_ThenComicListReturned() =
        runBlocking {
            // Given
            val mockDataProvider = mockk<ComicListDataProvider>()
            val comicItemRepository = ComicListRepositoryImpl(mockDataProvider)
            val comicItem1 = ComicItem(
                id = 1,
                title = "title",
                coverUrlPath = "imageUrl",
                coverUrlExtension = "",
                publishedDate = "",
                writer = "",
                penciler = "",
                description = "description"
            )
            val comicItem2 = ComicItem(
                id = 2,
                title = "different title2",
                coverUrlPath = "different imageUrl2",
                coverUrlExtension = "",
                publishedDate = "",
                writer = "",
                penciler = "",
                description = "different description2"
            )

            val mutableStateFlow = MutableStateFlow<List<ComicItem>>(emptyList())

            // When
            coEvery {
                mockDataProvider.getComicList(
                    any(),
                    any()
                )
            } returns listOf(comicItem1, comicItem2)

            // Then
            val comicList = comicItemRepository.getComicList(2, 0)
            assertEquals(2, comicList.size)
        }

    @Test
    fun givenLimitAndOffset_WhenGetComicListInvoked_ThenEmptyListReturned() =
        runBlocking {
            // Given
            val mockDataProvider = mockk<ComicListDataProvider>()
            val comicItemRepository = ComicListRepositoryImpl(mockDataProvider)

            // When
            coEvery {
                mockDataProvider.getComicList(
                    any(),
                    any()
                )
            } returns emptyList()

            // Then
            val comicList = comicItemRepository.getComicList(10, 0)
            assertEquals(comicList.size, 0)

        }


}
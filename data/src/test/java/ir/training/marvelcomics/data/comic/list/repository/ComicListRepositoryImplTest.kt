package ir.training.marvelcomics.data.comic.list.repository

import app.cash.turbine.test
import io.mockk.coEvery
import io.mockk.mockk
import ir.training.marvelcomics.data.comic.list.dataprovider.ComicListDataProvider
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
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
                    any(),
                    mutableStateFlow
                )
            } coAnswers {
                yield()
                mutableStateFlow.update { comicItems: List<ComicItem> ->
                    comicItems + listOf(
                        comicItem1,
                        comicItem2
                    )
                }
            }

            // Then
            mutableStateFlow.test {
                assertEquals(0, awaitItem().size)
                comicItemRepository.getComicList(2, 0, mutableStateFlow)
                assertEquals(2, awaitItem().size)
                assertEquals(cancelAndConsumeRemainingEvents().size, 0)
            }
        }

    @Test
    fun givenLimitAndOffset_WhenGetComicListInvoked_ThenEmptyListReturned() =
        runBlocking {
            // Given
            val mockDataProvider = mockk<ComicListDataProvider>()
            val comicItemRepository = ComicListRepositoryImpl(mockDataProvider)

            val mutableStateFlow = MutableStateFlow<List<ComicItem>>(emptyList())

            // When
            coEvery {
                mockDataProvider.getComicList(
                    any(),
                    any(),
                    mutableStateFlow
                )
            } coAnswers {
                yield()
                mutableStateFlow.update { comicItems: List<ComicItem> ->
                    comicItems
                }
            }

            // Then
            mutableStateFlow.test {
                assertEquals(0, awaitItem().size)
                comicItemRepository.getComicList(10, 0, mutableStateFlow)
                assertEquals(cancelAndConsumeRemainingEvents().size, 0)
            }
        }


}
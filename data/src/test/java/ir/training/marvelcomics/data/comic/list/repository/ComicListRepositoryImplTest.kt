package ir.training.marvelcomics.data.comic.list.repository

import androidx.paging.PagingData
import app.cash.turbine.test
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
    fun givenLimitAndOffset_WhenGetComicListInvoked_ThenEmptyListReturned() =
        runBlocking {
            // Given
            val mockDataProvider = mockk<ComicListDataProvider>()
            val comicItemRepository = ComicListRepositoryImpl(mockDataProvider)

            val comicItem = ComicItem(
                id = 1,
                title = "title",
                coverUrlPath = "description",
                coverUrlExtension = "",
                publishedDate = "",
                writer = "",
                penciler = "",
                description = ""
            );

            val mutableStateFlow = MutableStateFlow(
                PagingData.from(
                    listOf<ComicItem>()
                )
            )

            // When
            coEvery {
                mockDataProvider.getComicList()
            } returns mutableStateFlow

            // Then
            val comicList = comicItemRepository.getComicList()
            assertEquals(comicList, mutableStateFlow)

            val data = PagingData.from(listOf(comicItem))

            mutableStateFlow.emit(data)

            mutableStateFlow.test {
                assertEquals(data, awaitItem())
            }

        }


}
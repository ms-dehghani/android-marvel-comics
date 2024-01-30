package ir.training.marvelcomics.domain.usecase.comic.item

import app.cash.turbine.test
import io.mockk.coEvery
import io.mockk.mockk
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.repository.comic.item.ComicItemRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class ComicItemUseCaseTest {

    private val mockRepository = mockk<ComicItemRepository>()

    private val getComicUseCase = ComicItemUseCase(mockRepository)

    @Test
    fun givenComicIdWhenGetComicUseCaseInvokedThenExpectedComicReturned() = runBlocking {
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
        coEvery { mockRepository.getComicById(any() , any()) } coAnswers {
            mutableStateFlow.value = expectedComicItem
        }

        mutableStateFlow.test {
            assertEquals(null, awaitItem())
            getComicUseCase.invoke(1, mutableStateFlow)
            assertEquals(expectedComicItem, awaitItem())
            assertEquals(cancelAndConsumeRemainingEvents().size, 0)
        }
    }

    @Test
    fun givenComicIdWhenGetComicUseCaseInvokedAndComicIsNotFoundThenNullComicReturned() =
        runBlocking {
            val mutableStateFlow = MutableStateFlow<ComicItem?>(null)
            coEvery { mockRepository.getComicById(any() , any()) } coAnswers {
                mutableStateFlow.value = null
            }

            mutableStateFlow.test {
                assertEquals(null, awaitItem())
                getComicUseCase.invoke(1, mutableStateFlow)
                assertEquals(cancelAndConsumeRemainingEvents().size, 0)
            }
        }
}
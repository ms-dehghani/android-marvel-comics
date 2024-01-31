package ir.training.marvelcomics.domain.usecase.comic.item

import io.mockk.coEvery
import io.mockk.mockk
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.repository.comic.item.ComicItemRepository
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

        coEvery { mockRepository.getComicById(any()) } returns expectedComicItem

        val item = getComicUseCase.invoke(1)
        assertEquals(expectedComicItem, item)
    }

    @Test
    fun givenComicIdWhenGetComicUseCaseInvokedAndComicIsNotFoundThenNullComicReturned() =
        runBlocking {
            coEvery { mockRepository.getComicById(any()) } returns null

            val item = getComicUseCase.invoke(1)
            assertEquals(null, item)
        }
}
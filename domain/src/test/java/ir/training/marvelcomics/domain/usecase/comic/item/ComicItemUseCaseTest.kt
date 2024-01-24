package ir.training.marvelcomics.domain.usecase.comic.item

import io.mockk.coEvery
import io.mockk.mockk
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.repository.comic.item.ComicItemRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ComicItemUseCaseTest {

    private val mockRepository = mockk<ComicItemRepository>()

    private val getComicUseCase = ComicItemUseCase(mockRepository)

    @Test
    fun givenComicIdWhenGetComicUseCaseInvokedThenExpectedComicReturned() = runBlocking {
        // Given
        val comicId = 123
        val expectedComic: ComicItem = mockk()

        // When
        coEvery { mockRepository.getComicById(comicId) } returns expectedComic
        val result = getComicUseCase.invoke(comicId)

        // Then
        assertEquals(expectedComic, result)
    }

    @Test
    fun givenComicIdWhenGetComicUseCaseInvokedAndComicIsNotFoundThenNullComicReturned() =
        runBlocking {
            // Given
            val comicId = 123

            // When
            coEvery { mockRepository.getComicById(comicId) } returns null
            val result = getComicUseCase.invoke(comicId)

            // Then
            assertNull(result)
        }
}
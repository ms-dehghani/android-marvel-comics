package ir.training.marvelcomics.domain.usecase

import io.mockk.coEvery
import io.mockk.mockk
import ir.training.marvelcomics.domain.model.Comic
import ir.training.marvelcomics.domain.repository.ComicRepository
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.Test

class GetComicUseCaseTest {

    val mockRepository = mockk<ComicRepository>()

    val getComicUseCase = GetComicUseCase(mockRepository)

    @Test
    fun givenComicIdWhenGetComicUseCaseInvokedThenExpectedComicReturned() = runBlocking {
        // Given
        val comicId = 123
        val expectedComic: Comic = mockk()

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
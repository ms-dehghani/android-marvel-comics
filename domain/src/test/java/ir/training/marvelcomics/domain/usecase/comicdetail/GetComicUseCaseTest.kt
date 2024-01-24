package ir.training.marvelcomics.domain.usecase.comicdetail

import io.mockk.coEvery
import io.mockk.mockk
import ir.training.marvelcomics.domain.model.Comic
import ir.training.marvelcomics.domain.repository.comicdetail.ComicDetailRepository
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.Test

class GetComicUseCaseTest {

    val mockRepository = mockk<ComicDetailRepository>()

    val getComicUseCase = GetComicUseCase(mockRepository)

    @Test
    fun givenComicId_WhenGetComicUseCaseInvoked_ThenExpectedComicReturned() = runBlocking {

        val comicId = 123
        val expectedComic: Comic = mockk()

        coEvery { mockRepository.getComicById(comicId) } returns expectedComic
        val result = getComicUseCase.invoke(comicId)

        assertEquals(expectedComic, result)
    }

    @Test
    fun givenComicId_WhenGetComicUseCaseInvokedAndComicIsNotFound_ThenNullComicReturned() =
        runBlocking {

            val comicId = 123

            coEvery { mockRepository.getComicById(comicId) } returns null
            val result = getComicUseCase.invoke(comicId)

            assertNull(result)
        }
}
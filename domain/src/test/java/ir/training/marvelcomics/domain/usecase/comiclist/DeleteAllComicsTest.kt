package ir.training.marvelcomics.domain.usecase.comiclist

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import ir.training.marvelcomics.domain.repository.comiclist.ComicListRepository
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.jupiter.api.assertDoesNotThrow

class DeleteAllComicsTest {

    private val comicListRepository = mockk<ComicListRepository>()

    private val deleteAllComics = DeleteAllComics(comicListRepository)

    @Test
    fun givenPageNumber_WhenDeleteAllComicInvoked_ThenDeleteAllComicsCalled() = runBlocking {

        coEvery { comicListRepository.deleteAll() } returns Unit

        deleteAllComics()

        coVerify(exactly = 1) { comicListRepository.deleteAll() }

        assertDoesNotThrow { comicListRepository.deleteAll() }

    }
}

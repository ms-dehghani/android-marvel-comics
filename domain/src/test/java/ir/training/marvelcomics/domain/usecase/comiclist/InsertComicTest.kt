package ir.training.marvelcomics.domain.usecase.comiclist

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import ir.training.marvelcomics.domain.model.Comic
import ir.training.marvelcomics.domain.repository.comiclist.ComicListRepository
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.jupiter.api.assertDoesNotThrow

class InsertComicTest {

    private val comicListRepository = mockk<ComicListRepository>()

    private val insertComic = InsertComic(comicListRepository)

    private val comic: Comic = mockk(relaxed = true)

    @Test
    fun givenComic_WhenInsertComicInvoked_ThenInsertComicCalled() = runBlocking {

        coEvery { comicListRepository.insert(comic) } returns Unit

        insertComic(comic)

        coVerify(exactly = 1) { comicListRepository.insert(comic) }

        assertDoesNotThrow { insertComic(comic) }

    }
}

package ir.training.marvelcomics.domain.usecase.comiclist

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import ir.training.marvelcomics.domain.model.Comic
import org.junit.Test
import ir.training.marvelcomics.domain.repository.comiclist.ComicListRepository
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.assertDoesNotThrow

internal class InsertAllComicTest {

    private val comicListRepository = mockk<ComicListRepository>()

    private val insertAllComics = InsertAllComics(comicListRepository)

    private var comics: List<Comic> = mockk(relaxed = true)


    @Test
    fun givenComicsList_WhenInsertAllComicsInvoked_ThenExpectedComicsListInserted() = runBlocking {

        coEvery { comicListRepository.insertAll(comics) } returns Unit

        insertAllComics(comics)

        coVerify(exactly = 1) { comicListRepository.insertAll(comics) }

        assertDoesNotThrow { insertAllComics(comics) }
    }
}





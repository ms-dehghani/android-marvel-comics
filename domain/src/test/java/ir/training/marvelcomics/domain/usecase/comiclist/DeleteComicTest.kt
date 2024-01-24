package ir.training.marvelcomics.domain.usecase.comiclist

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import ir.training.marvelcomics.domain.model.Comic
import ir.training.marvelcomics.domain.repository.comiclist.ComicListRepository
import kotlinx.coroutines.runBlocking
import org.junit.Test


class DeleteComicTest {

    private val comicListRepository = mockk<ComicListRepository>()

    private val deleteComic = DeleteComic(comicListRepository)

    private val comic: Comic = mockk(relaxed = true)

    @Test
    fun givenComic_WhenDeleteComicInvoked_ThenDeleteComicCalled() = runBlocking {

        coEvery { deleteComic(comic = comic) } returns Unit

        deleteComic(comic = comic)

        coVerify { comicListRepository.delete(comic = comic) }

    }
}

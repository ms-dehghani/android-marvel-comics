package ir.training.marvelcomics.domain.usecase.comiclist

import io.mockk.mockk
import ir.training.marvelcomics.domain.model.Comic
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import io.mockk.every
import ir.training.marvelcomics.domain.repository.comiclist.ComicListRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

internal class GetAllComicsTest {

    private val comicListRepository = mockk<ComicListRepository>()

    private val getAllComics = GetAllComics(comicListRepository)

    @Test
    fun givenPageNumber_WhenGetAllComicUseCaseInvoked_ThenExpectedComicsListReturned() =
        runBlocking {

            val page = 1
            val expectedComicList = listOf(
                Comic(
                    id = 1,
                    title = "Batman",
                    coverUrl = "url1",
                    publishedDate = "published Date1",
                    writer = "Writer1",
                    penciler = "Penciler1",
                    description = "Description1"
                ), Comic(
                    id = 2,
                    title = "Superman",
                    coverUrl = "url2",
                    publishedDate = "published Date2",
                    writer = "Writer2",
                    penciler = "Penciler2",
                    description = "Description2"
                )
            )
            every { comicListRepository.getAll(page) } returns flow { emit(expectedComicList) }

            val result = getAllComics(page)

            result.collect { comics ->
                assertEquals(expectedComicList, comics)
            }
        }
}





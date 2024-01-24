package ir.training.marvelcomics.domain.usecase.comic.list

import io.mockk.coEvery
import io.mockk.mockk
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.repository.comic.list.ComicListRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

internal class ComicListUseCaseTest {

    private val comicListRepository = mockk<ComicListRepository>()

    private val comicListUseCase = ComicListUseCase(comicListRepository)


    @Test
    fun givenPageNumber_WhenGetAllComicUseCaseInvoked_ThenExpectedComicsListReturned() =
        runBlocking {

            val page = 1
            val expectedComicList = listOf(
                ComicItem(
                    id = 1,
                    title = "Batman",
                    coverUrl = "url1",
                    publishedDate = "published Date1",
                    writer = "Writer1",
                    penciler = "Penciler1",
                    description = "Description1"
                ), ComicItem(
                    id = 2,
                    title = "Superman",
                    coverUrl = "url2",
                    publishedDate = "published Date2",
                    writer = "Writer2",
                    penciler = "Penciler2",
                    description = "Description2"
                )
            )
            coEvery { comicListRepository.getAll(page) } returns expectedComicList

            val result = comicListUseCase.invoke(page)

            assertEquals(expectedComicList, result)
        }
}





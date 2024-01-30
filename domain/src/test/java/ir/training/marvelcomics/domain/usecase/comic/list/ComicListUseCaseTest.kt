package ir.training.marvelcomics.domain.usecase.comic.list

import app.cash.turbine.test
import io.mockk.coEvery
import io.mockk.mockk
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.repository.comic.list.ComicListRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

internal class ComicListUseCaseTest {

    private val comicListRepository = mockk<ComicListRepository>()

    private val comicListUseCase = ComicListUseCase(comicListRepository)


    @Test
    fun givenPageNumber_WhenGetAllComicUseCaseInvoked_ThenExpectedComicsListReturned() =
        runBlocking {

            val expectedComicList = listOf(
                ComicItem(
                    id = 1,
                    title = "Batman",
                    coverUrlPath = "url1",
                    coverUrlExtension = "url1",
                    publishedDate = "published Date1",
                    writer = "Writer1",
                    penciler = "Penciler1",
                    description = "Description1"
                ), ComicItem(
                    id = 2,
                    title = "Superman",
                    coverUrlPath = "url2",
                    coverUrlExtension = "url2",
                    publishedDate = "published Date2",
                    writer = "Writer2",
                    penciler = "Penciler2",
                    description = "Description2"
                )
            )

            val mutableStateFlow = MutableStateFlow<List<ComicItem>>(emptyList())


            coEvery {
                comicListRepository.getComicList(
                    any(),
                    any(), any()
                )
            } coAnswers {
                mutableStateFlow.value = listOf(
                    ComicItem(
                        id = 1,
                        title = "Batman",
                        coverUrlPath = "url1",
                        coverUrlExtension = "url1",
                        publishedDate = "published Date1",
                        writer = "Writer1",
                        penciler = "Penciler1",
                        description = "Description1"
                    ), ComicItem(
                        id = 2,
                        title = "Superman",
                        coverUrlPath = "url2",
                        coverUrlExtension = "url2",
                        publishedDate = "published Date2",
                        writer = "Writer2",
                        penciler = "Penciler2",
                        description = "Description2"
                    )
                )
            }


            mutableStateFlow.test {
                assertEquals(emptyList<ComicItem>(), awaitItem())
                comicListUseCase.invoke(10, 0, mutableStateFlow)
                assertEquals(expectedComicList, awaitItem())
            }
        }
}





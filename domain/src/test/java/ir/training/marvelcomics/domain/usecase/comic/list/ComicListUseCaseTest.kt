package ir.training.marvelcomics.domain.usecase.comic.list

import androidx.paging.PagingData
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

            val mutableStateFlow = MutableStateFlow(
                PagingData.from(
                    listOf(
                        ComicItem(
                            1,
                            "title",
                            "description",
                            "",
                            "",
                            "",
                            "",
                            ""
                        )
                    )
                )
            )

            coEvery {
                comicListRepository.getComicList()
            } returns mutableStateFlow

            val result = comicListUseCase.invoke()
            assertEquals(mutableStateFlow, result)
        }
}





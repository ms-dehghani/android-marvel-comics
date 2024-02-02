package ir.training.marvelcomics.viewmodel.list

import androidx.paging.PagingData
import io.mockk.coEvery
import io.mockk.mockk
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.usecase.comic.list.ComicListUseCase
import ir.training.marvelcomics.main.viewmodel.comic.list.ComicListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ComicListViewModelTest {

    private lateinit var viewModel: ComicListViewModel

    private var comicListUseCase: ComicListUseCase = mockk(relaxed = true)

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = ComicListViewModel(comicListUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun givenLimitAndOffset_WhenCollectComicItemsCalls_ThenFillListReturned() = runTest {

        val mutableStateFlow = MutableStateFlow(
            PagingData.from(
                listOf(
                    ComicItem(
                        id = 1,
                        title = "title",
                        coverUrlPath = "description",
                        coverUrlExtension = "",
                        publishedDate = "",
                        writer = "",
                        penciler = "",
                        description = ""
                    )
                )
            )
        )

        coEvery {
            comicListUseCase.invoke()
        } returns mutableStateFlow

        val result = comicListUseCase.invoke()
        assertEquals(mutableStateFlow, result)
    }

}
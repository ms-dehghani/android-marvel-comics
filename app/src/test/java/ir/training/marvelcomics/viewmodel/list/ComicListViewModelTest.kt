package ir.training.marvelcomics.viewmodel.list

import app.cash.turbine.test
import io.mockk.coEvery
import io.mockk.mockk
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.usecase.comic.list.ComicListUseCase
import ir.training.marvelcomics.main.state.base.PageState
import ir.training.marvelcomics.main.viewmodel.comic.list.ComicListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
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
    fun givenLimitAndOffset_WhenCollectComicItemsCalls_ThenEmptyListReturned() = runBlocking {
        coEvery { comicListUseCase.invoke(any(), any()) } returns listOf()

        viewModel.collectComicItems()

        assertEquals(viewModel.state.value.comicList.size, 0)
    }

    @Test
    fun givenLimitAndOffset_WhenCollectComicItemsCalls_ThenFillListReturned() = runTest {
        coEvery { comicListUseCase.invoke(any(), any()) } returns listOf(
            ComicItem(
                id = 1,
                title = "title",
                description = "description",
                coverUrlExtension = "",
                coverUrlPath = "",
                penciler = "",
                publishedDate = "",
                writer = ""
            )
        )

        viewModel.state.test {
            viewModel.collectComicItems()
            val item = awaitItem()
            assertEquals(item.comicList.size, 1)
            assertEquals(PageState.SUCCESS, item.pageState)
        }
    }

}
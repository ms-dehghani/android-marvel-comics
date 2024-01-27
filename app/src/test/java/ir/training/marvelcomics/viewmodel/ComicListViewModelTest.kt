package ir.training.marvelcomics.viewmodel
import androidx.paging.PagingData
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.usecase.comic.list.ComicListUseCase
import ir.training.marvelcomics.main.view.list.ComicListEvent
import ir.training.marvelcomics.main.viewmodel.ComicListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ComicListViewModelTest {

    private lateinit var viewModel: ComicListViewModel

    private  var comicListUseCase: ComicListUseCase = mockk(relaxed = true)

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
    fun `test collectComicItems`() = runBlocking {
        val pagingData: PagingData<ComicItem> = mockk()
        coEvery { comicListUseCase(any()) } returns flowOf(pagingData)

        viewModel.collectComicItems()

        assertEquals(viewModel.state.value.comicList , pagingData )
    }

    @Test
    fun `test onEvent`() {
        val event = ComicListEvent.OnLoadMoreButtonClicked
        viewModel.onEvent(event)

        coVerify { comicListUseCase(1) }
        assertEquals(1, viewModel.currentPage.value)
    }

    @Test
    fun `test updatePage`() {
        viewModel.updatePage(2)

        assertEquals(2, viewModel.currentPage.value)
    }
}
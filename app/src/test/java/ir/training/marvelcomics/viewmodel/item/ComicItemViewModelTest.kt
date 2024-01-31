package ir.training.marvelcomics.viewmodel.item

import androidx.lifecycle.SavedStateHandle
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.usecase.comic.item.ComicItemUseCase
import ir.training.marvelcomics.main.view.item.contract.ComicItemEffect
import ir.training.marvelcomics.main.view.item.contract.ComicItemEvent
import ir.training.marvelcomics.main.viewmodel.ComicItemViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ComicItemViewModelTest {

    private lateinit var viewModel: ComicItemViewModel
    private val comicItemUseCase: ComicItemUseCase = mockk(relaxed = true)
    private val savedStateHandle: SavedStateHandle = mockk(relaxed = true)

    @Before
    fun setup() {
        viewModel = ComicItemViewModel(comicItemUseCase, savedStateHandle)
    }

    @Test
    fun givenComicIdThroughSavedStateHandle_WhenViewModelInitialized_ThenViewModelComicIdShouldBeEqualToExpectedId() =
        runBlocking {
            val comicId = 123
            ComicItem(
                id = comicId,
                title = "Superman",
                coverUrlPath = "url2",
                coverUrlExtension = "url2",
                publishedDate = "published Date2",
                writer = "Writer2",
                penciler = "Penciler2",
                description = "Description2"
            )
            coEvery { savedStateHandle.get<Int>("noteId") } returns comicId

            viewModel = ComicItemViewModel(comicItemUseCase, savedStateHandle)

            assertEquals(viewModel.state.value.comicId, comicId)

          coVerify{comicItemUseCase.invoke(comicId)}
      }

      @Test
      fun givenOnBackButtonClickedEvent_WhenViewModelOnEventCalled_ThenNavigateToComicListScreenEffectShouldBeEmitted() {
          val event = ComicItemEvent.OnBackButtonClicked

          viewModel.onEvent(event)

          val effect = viewModel.effectFlow.replayCache.firstOrNull()
          assertEquals(effect, ComicItemEffect.NavigateToComicListScreen)

      }
}
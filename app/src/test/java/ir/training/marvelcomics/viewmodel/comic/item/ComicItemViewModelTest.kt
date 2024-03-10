package ir.training.marvelcomics.viewmodel.comic.item

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.usecase.comic.item.ComicItemUseCase
import ir.training.marvelcomics.main.view.pages.comic.item.contract.ComicItemEffect
import ir.training.marvelcomics.main.view.pages.comic.item.contract.ComicItemEvent
import ir.training.marvelcomics.main.viewmodel.comic.item.ComicItemViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ComicItemViewModelTest {

    private lateinit var viewModel: ComicItemViewModel
    private val comicItemUseCase: ComicItemUseCase = mockk(relaxed = true)
    private val savedStateHandle: SavedStateHandle = mockk(relaxed = true)

    private val dispatchers = Dispatchers.Default

    @Before
    fun setup() {
        every { savedStateHandle.get<Int>(any()) } returns 123
        viewModel = ComicItemViewModel(comicItemUseCase, savedStateHandle, dispatchers)
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

            viewModel = ComicItemViewModel(comicItemUseCase, savedStateHandle, dispatchers)

            assertEquals(viewModel.state.value.comicId, comicId)

            coVerify { comicItemUseCase.invoke(comicId) }
        }

    @Test
    fun givenOnBackButtonClickedEvent_WhenViewModelOnEventCalled_ThenNavigateToComicListScreenEffectShouldBeEmitted() {
        val event = ComicItemEvent.OnBackButtonClicked

        viewModel.onEvent(event)

        val effect = viewModel.effectFlow.replayCache.firstOrNull()
        assertEquals(effect, ComicItemEffect.NavigateToComicListScreen)

    }
}
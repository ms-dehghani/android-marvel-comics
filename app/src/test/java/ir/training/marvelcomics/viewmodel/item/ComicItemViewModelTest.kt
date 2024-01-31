package ir.training.marvelcomics.viewmodel.item

class ComicItemViewModelTest {

    /*  private lateinit var viewModel: ComicItemViewModel
      private val comicItemUseCase: ComicItemUseCase = mockk(relaxed = true)
      private val savedStateHandle: SavedStateHandle = mockk(relaxed = true)

      @Before
      fun setup() {
          viewModel = ComicItemViewModel(comicItemUseCase, savedStateHandle)
      }

      @Test
      fun givenComicIdThroughSavedStateHandle_WhenViewModelInitialized_ThenViewModelComicIdShouldBeEqualToExpectedId() = runBlocking {
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

          assertEquals(viewModel.state.value.comicId,comicId)

          coVerify{comicItemUseCase.invoke(comicId)}
      }

      @Test
      fun givenOnBackButtonClickedEvent_WhenViewModelOnEventCalled_ThenNavigateToComicListScreenEffectShouldBeEmitted() {
          val event = ComicItemEvent.OnBackButtonClicked

          viewModel.onEvent(event)

          val effect = viewModel.effectFlow.replayCache.firstOrNull()
          assertEquals(effect,ComicItemEffect.NavigateToComicListScreen)

      }
  */
}
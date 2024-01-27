package ir.training.marvelcomics.view.list

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.paging.compose.LazyPagingItems
import io.mockk.mockk
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.main.view.list.components.GridList
import org.junit.Rule
import org.junit.Test

class GridListTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun givenMockedComicList_WhenGridListIsDisplayed_ThenLoadNextPageButtonShouldBeVisible() {

        val comicItems: LazyPagingItems<ComicItem> = mockk(relaxed = true)

        composeTestRule.setContent {
            GridList(
                comicItems = comicItems,
                onLoadMoreButtonClicked = {},
                onComicClicked = {}
            )
        }

        composeTestRule.onNodeWithText("Load Next Page").assertExists()

        composeTestRule.onNodeWithText("Load Next Page")
            .performClick()

    }

    @Test
    fun givenMockedComicList_WhenGridListIsDisplayed_ThenExpectedComicItemsShouldBeVisible() {

        val comicItems: LazyPagingItems<ComicItem> = mockk(relaxed = true)

        composeTestRule.setContent {
            GridList(
                comicItems = comicItems,
                onLoadMoreButtonClicked = {},
                onComicClicked = {}
            )
        }

        composeTestRule.onAllNodesWithTag("ComicItem").assertCountEquals(comicItems.itemCount)

    }

}
package ir.training.marvelcomics.main.view.widgets.list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class GridListLoadMoreTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun givenEmptyList_WhenGridListIsDisplayed_ThenEmptyTextVisible() {

        composeTestRule.setContent {
            GridListLoadMore(
                itemCount = 0,
                lazyVerticalGrid = {},
                showLoading = false,
            )
        }

        composeTestRule.onNodeWithText("No item found!").assertExists()
    }

    @Test
    fun givenMockedList_WhenGridListIsDisplayed_ThenExpectedListShouldBeVisible() {

        val id = "id"
        val list = listOf("1")

        composeTestRule.setContent {
            GridListLoadMore(
                lazyVerticalGrid = {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(1),
                    ) {
                        items(
                            count = list.size,
                        ) { index ->
                            Text(list[index])
                        }
                    }
                },
                itemCount = 1,
                showLoading = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag(id),
            )
        }

        composeTestRule.onNodeWithTag(id).assertExists()
        composeTestRule.onNodeWithText(list[0]).assertExists()
    }

}
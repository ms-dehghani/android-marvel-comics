package ir.training.marvelcomics.main.view.widgets.list

import androidx.compose.foundation.layout.fillMaxWidth
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
                items = listOf(),
                onLoadMoreListener = {},
                showLoading = false,
            )
        }

        composeTestRule.onNodeWithText("No items found!").assertExists()
    }

    @Test
    fun givenMockedList_WhenGridListIsDisplayed_ThenExpectedListShouldBeVisible() {

        val id = "id"
        val list = listOf("1")

        composeTestRule.setContent {
            GridListLoadMore(
                items = list.map { text ->
                    {
                        Text(text = text)
                    }
                },
                onLoadMoreListener = {},
                showLoading = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag(id),
            )
        }

        composeTestRule.onNodeWithTag(id).assertExists()
    }

}
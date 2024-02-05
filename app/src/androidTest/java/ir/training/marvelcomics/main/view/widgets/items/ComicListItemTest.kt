package ir.training.marvelcomics.view.widgets.items


import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.main.view.widgets.list.items.ComicListItem
import org.junit.Rule
import org.junit.Test

class ComicListItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun givenMockedComic_WhenComicListItemIsDisplayed_ThenExpectedViewsShouldBeVisible() {
        val comicItem = ComicItem(
            id = 1,
            title = "The Amazing Spider-Man",
            coverUrlPath = "https://example.com/spiderman.jpg",
            coverUrlExtension = "",
            publishedDate = "1963-03-01",
            writer = "Stan Lee",
            penciler = "Penciler",
            description = "Description",
        )

        composeTestRule.setContent {
            ComicListItem(
                comicItem = comicItem,
                onComicClicked = {}
            )
        }

        composeTestRule.onNode(hasText("1963-03-01"))
            .assertExists()

        composeTestRule.onNode(hasText("Stan Lee"))
            .assertExists()

        composeTestRule.onNode(hasText("The Amazing Spider-Man"))
            .assertExists()
    }
}

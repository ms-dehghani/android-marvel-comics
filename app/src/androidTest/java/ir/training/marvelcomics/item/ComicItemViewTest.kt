package ir.training.marvelcomics.item

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.main.view.item.components.ComicItemView
import org.junit.Rule
import org.junit.Test

class GridListTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun givenComicItem_WhenComicItemScreenStarts_ThenAllViewShouldBeDisplayed() {
        val comic = ComicItem(
            id = 1,
            title = "The Amazing Spider-Man",
            publishedDate = "2022-01-01",
            coverUrlPath = "",
            coverUrlExtension = "",
            writer = "Stan Lee",
            penciler = "Steve Ditko",
            description = "The Amazing Spider-Man is a comic book series published by Marvel Comics, featuring the fictional superhero Spider-Man as its main protagonist. Being one of the most popular comic book series of all time, it has been adapted into various media including films, television series, and video games."
        )

        composeTestRule.setContent {
            ComicItemView(comic = comic)
        }

        composeTestRule.onNodeWithText(text = comic.title).assertIsDisplayed()

        composeTestRule.onNodeWithText(text = comic.publishedDate).assertIsDisplayed()

        composeTestRule.onNodeWithText(text = comic.writer).assertIsDisplayed()

        composeTestRule.onNodeWithText(text = comic.penciler).assertIsDisplayed()

        composeTestRule.onNodeWithText(text = comic.description).assertIsDisplayed()
    }
}
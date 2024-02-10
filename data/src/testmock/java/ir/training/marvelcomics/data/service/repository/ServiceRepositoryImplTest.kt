package ir.training.marvelcomics.data.service.repository

import androidx.paging.map
import app.cash.turbine.test
import ir.training.marvelcomics.data.service.ServiceRepositoryImpl
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class ServiceRepositoryImplTest {

    @Test
    fun testGetComicById() = runBlocking {
        // Given
        val comicId = 1
        val expectedComicItem = ComicItem(
            id = comicId,
            title = "title",
            coverUrlPath = "coverUrl",
            coverUrlExtension = "",
            publishedDate = "",
            writer = "",
            penciler = "",
            description = ""
        )
        val serviceRepository = ServiceRepositoryImpl()

        // When
        val comicById = serviceRepository.getComicById(comicId)

        // Then
        assertEquals(expectedComicItem, comicById)
    }

    @Test
    fun testGetComicList() = runBlocking {
        // Given
        val serviceRepository = ServiceRepositoryImpl()

        val expectedComicItem = ComicItem(
            id = 1,
            title = "title",
            coverUrlPath = "",
            coverUrlExtension = "",
            publishedDate = "",
            writer = "",
            penciler = "",
            description = ""
        )
        // When
        val comicList = serviceRepository.getComicList()

        // Then
        comicList.test {
            val item = awaitItem()
            item.map { comicItem ->
                assertEquals(expectedComicItem, comicItem)}
        }
    }

}
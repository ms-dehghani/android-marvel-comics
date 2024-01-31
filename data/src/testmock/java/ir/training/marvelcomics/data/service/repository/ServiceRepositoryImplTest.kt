package ir.training.marvelcomics.data.service.repository

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

        // When
        val comicList = serviceRepository.getComicList(1, 0)

        // Then
        assertEquals(1, comicList.size)
    }

}
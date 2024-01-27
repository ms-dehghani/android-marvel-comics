package ir.training.marvelcomics.data.service.repository

import ir.training.marvelcomics.data.service.ServiceRepositoryImpl
import ir.training.marvelcomics.domain.model.ComicItem
import kotlinx.coroutines.flow.MutableStateFlow
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
            coverUrl = "coverUrl",
            publishedDate = "",
            writer = "",
            penciler = "",
            description = ""
        )
        val mutableStateFlow = MutableStateFlow<ComicItem?>(null)
        val serviceRepository = ServiceRepositoryImpl()

        // When
        serviceRepository.getComicById(comicId, mutableStateFlow)

        // Then
        assertEquals(expectedComicItem, mutableStateFlow.value)
    }
}
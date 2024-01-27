package ir.training.marvelcomics.data.item.repository.db.dao


import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import ir.training.marvelcomics.data.service.dto.db.comic.item.ComicDbItem
import ir.training.marvelcomics.data.service.repository.db.ComicDB
import ir.training.marvelcomics.data.service.repository.db.dao.ComicDao
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ComicDaoTest {

    private lateinit var comicDao: ComicDao
    private lateinit var db: ComicDB

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, ComicDB::class.java).allowMainThreadQueries().build()
        comicDao = db.comicDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun testGetComicById() = runBlocking {
        // Given
        val comicId = 1
        val expectedComicItem = ComicDbItem(
            id = comicId,
            title = "title",
            coverUrl = "coverUrl",
            description = ""
        )
        comicDao.insert(expectedComicItem)

        // When
        val actualComicItem = comicDao.getComicById(comicId)

        // Then
        assertFalse(actualComicItem == null)
        assertEquals(expectedComicItem.id, actualComicItem!!.id)
        assertEquals(expectedComicItem.title, actualComicItem.title)
        assertEquals(expectedComicItem.description, actualComicItem.description)
        assertEquals(expectedComicItem.coverUrl, actualComicItem.coverUrl)
    }

    @Test
    fun testGetAll() = runBlocking {
        // Given
        val comicList = listOf(
            ComicDbItem(
                id = 1,
                title = "title1",
                coverUrl = "coverUrl1",
                description = "description1"
            ),
            ComicDbItem(
                id = 2,
                title = "title2",
                coverUrl = "coverUrl2",
                description = "description2"
            )
        )
        comicDao.insertAll(comicList)

        // When
        val actualComicList = comicDao.getAll(2, 0)

        // Then
        assertFalse(actualComicList.isEmpty())
        assertEquals(comicList.size, actualComicList.size)
        for (i in comicList.indices) {
            assertEquals(comicList[i].id, actualComicList[i].id)
            assertEquals(comicList[i].title, actualComicList[i].title)
            assertEquals(comicList[i].description, actualComicList[i].description)
            assertEquals(comicList[i].coverUrl, actualComicList[i].coverUrl)
        }
    }

    @Test
    fun testDelete() = runBlocking {
        // Given
        val comicItem = ComicDbItem(
            id = 1,
            title = "title",
            coverUrl = "coverUrl",
            description = "description"
        )
        comicDao.insert(comicItem)

        // When
        comicDao.delete(comicItem)
        val actualComicItem = comicDao.getComicById(comicItem.id)

        // Then
        assertEquals(null, actualComicItem)
    }

    @Test
fun testInsertAll() = runBlocking {
    // Given
    val comicList = listOf(
        ComicDbItem(
            id = 1,
            title = "title1",
            coverUrl = "coverUrl1",
            description = "description1"
        ),
        ComicDbItem(
            id = 2,
            title = "title2",
            coverUrl = "coverUrl2",
            description = "description2"
        )
    )

    // When
    comicDao.insertAll(comicList)
    val actualComicList = comicDao.getAll(2, 0)

    // Then
    assertFalse(actualComicList.isEmpty())
    assertEquals(comicList.size, actualComicList.size)
    for (i in comicList.indices) {
        assertEquals(comicList[i].id, actualComicList[i].id)
        assertEquals(comicList[i].title, actualComicList[i].title)
        assertEquals(comicList[i].description, actualComicList[i].description)
        assertEquals(comicList[i].coverUrl, actualComicList[i].coverUrl)
    }
}

}
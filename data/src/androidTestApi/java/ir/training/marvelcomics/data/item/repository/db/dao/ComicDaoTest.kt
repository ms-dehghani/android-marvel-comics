package ir.training.marvelcomics.data.item.repository.db.dao


import android.content.Context
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.mockk.coEvery
import io.mockk.mockk
import ir.training.marvelcomics.data.service.dto.db.comic.ComicDbItem
import ir.training.marvelcomics.data.service.repository.db.ComicDB
import ir.training.marvelcomics.data.service.repository.db.dao.ComicDao
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.domain.repository.comic.list.ComicListRepository
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
    private val mockComicDao = mockk<ComicDao>()

    private lateinit var db: ComicDB

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, ComicDB::class.java).allowMainThreadQueries()
            .build()
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
            id = 1,
            title = "title",
            coverUrlPath = "coverUrlPath",
            coverUrlExtension = "coverUrlExtension",
            comicID = comicId,
            writer = "",
            penciler = "",
            publishedDate = "",
            description = ""
        )
        comicDao.insert(expectedComicItem)

        // When
        val actualComicItem = comicDao.getComicById(comicId)

        // Then
        assertFalse(actualComicItem == null)
        assertEquals(expectedComicItem.id, actualComicItem!!.id)
        assertEquals(expectedComicItem.comicID, actualComicItem.comicID)
        assertEquals(expectedComicItem.title, actualComicItem.title)
        assertEquals(expectedComicItem.description, actualComicItem.description)
        assertEquals(expectedComicItem.coverUrlPath, actualComicItem.coverUrlPath)
        assertEquals(expectedComicItem.coverUrlExtension, actualComicItem.coverUrlExtension)
        assertEquals(expectedComicItem.writer, actualComicItem.writer)
        assertEquals(expectedComicItem.penciler, actualComicItem.penciler)
    }

    @Test
    fun testGetAll() = runBlocking {
        // Given
        val comicList = listOf(
            ComicDbItem(
                id = 1,
                title = "title1",
                coverUrlPath = "coverUrlPath",
                coverUrlExtension = "coverUrlExtension",
                comicID = 1,
                writer = "writer1",
                penciler = "penciler1",
                publishedDate = "publishedDate1",
                description = "description1"
            ),
            ComicDbItem(
                id = 2,
                title = "title2",
                coverUrlPath = "coverUrlPath2",
                coverUrlExtension = "coverUrlExtension2",
                writer = "writer2",
                penciler = "penciler2",
                publishedDate = "publishedDate2",
                comicID = 2,
                description = "description2"
            )
        )

        val pagingSource = object : PagingSource<Int, ComicDbItem>() {
            override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ComicDbItem> {
                return LoadResult.Page(comicList, null, null)
            }

            override fun getRefreshKey(state: PagingState<Int, ComicDbItem>): Int? {
                return 0
            }

        }

        coEvery { mockComicDao.getComicList() } returns pagingSource

        // When
        val actualPagingSource = mockComicDao.getComicList()

        // Then
        val actualComicList = (actualPagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 20,
                placeholdersEnabled = false
            )
        ) as PagingSource.LoadResult.Page).data
        assertEquals(comicList, actualComicList)
    }

    @Test
    fun testDelete() = runBlocking {
        // Given
        val comicItem = ComicDbItem(
            id = 1,
            title = "title",
            coverUrlPath = "coverUrlPath",
            coverUrlExtension = "coverUrlExtension",
            comicID = 1,
            writer = "writer",
            penciler = "penciler",
            publishedDate = "publishedDate",
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
                coverUrlPath = "coverUrlPath",
                coverUrlExtension = "coverUrlExtension",
                comicID = 1,
                writer = "writer1",
                penciler = "penciler1",
                publishedDate = "publishedDate1",
                description = "description1"
            ),
            ComicDbItem(
                id = 2,
                title = "title2",
                coverUrlPath = "coverUrlPath2",
                coverUrlExtension = "coverUrlExtension2",
                writer = "writer2",
                penciler = "penciler2",
                publishedDate = "publishedDate2",
                comicID = 2,
                description = "description2"
            )
        )

        // When
        comicDao.insertAll(comicList)

        // Then
        val actualPagingSource = comicDao.getComicList()

        val actualComicList = (actualPagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 20,
                placeholdersEnabled = false
            )
        ) as PagingSource.LoadResult.Page).data

        assertFalse(actualComicList.isEmpty())
        assertEquals(comicList.size, actualComicList.size)
        for (i in comicList.indices) {
            assertEquals(comicList[i].id, actualComicList[i].id)
            assertEquals(comicList[i].title, actualComicList[i].title)
            assertEquals(comicList[i].description, actualComicList[i].description)
            assertEquals(comicList[i].coverUrlPath, actualComicList[i].coverUrlPath)
            assertEquals(comicList[i].coverUrlExtension, actualComicList[i].coverUrlExtension)
        }
    }

}
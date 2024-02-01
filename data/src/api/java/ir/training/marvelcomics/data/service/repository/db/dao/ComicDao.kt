package ir.training.marvelcomics.data.service.repository.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.training.marvelcomics.data.service.dto.db.comic.ComicDbItem

@Dao
interface ComicDao {
    @Query("SELECT * FROM comic order by id desc LIMIT :limit OFFSET :offset")
    fun getComicList(limit: Int, offset: Int): List<ComicDbItem>

    @Query("SELECT * FROM comic WHERE id = :id limit 1")
    fun getComicById(id: Int): ComicDbItem?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(comic: ComicDbItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(comic: List<ComicDbItem>)

    @Delete
    fun delete(user: ComicDbItem)
}
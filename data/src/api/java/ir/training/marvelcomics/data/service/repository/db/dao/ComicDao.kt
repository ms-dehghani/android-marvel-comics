package ir.training.marvelcomics.data.service.repository.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ir.training.marvelcomics.data.service.dto.db.comic.ComicDbItem

@Dao
interface ComicDao {
    @Query("SELECT * FROM comic LIMIT :limit OFFSET :offset")
    fun getAll(limit: Int, offset: Int): List<ComicDbItem>

    @Query("SELECT * FROM comic WHERE id = :id limit 1")
    fun getComicById(id: Int): ComicDbItem?

    @Insert
    fun insert(comic: ComicDbItem)

    @Insert
    fun insertAll(comic: List<ComicDbItem>)

    @Delete
    fun delete(user: ComicDbItem)
}
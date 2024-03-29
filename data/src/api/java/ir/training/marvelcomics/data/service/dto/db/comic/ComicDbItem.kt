package ir.training.marvelcomics.data.service.dto.db.comic

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comic")
class ComicDbItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "comicID")
    val comicID: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "coverUrlPath")
    val coverUrlPath: String,
    @ColumnInfo(name = "coverUrlExtension")
    val coverUrlExtension: String,
    @ColumnInfo(name = "writer")
    val writer: String,
    @ColumnInfo(name = "penciler")
    val penciler: String,
    @ColumnInfo(name = "publishedDate")
    val publishedDate: String,
)
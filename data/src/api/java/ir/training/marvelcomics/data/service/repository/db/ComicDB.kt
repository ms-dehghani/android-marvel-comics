package ir.training.marvelcomics.data.service.repository.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.training.marvelcomics.data.service.dto.db.comic.ComicDbItem
import ir.training.marvelcomics.data.service.repository.db.dao.ComicDao

@Database(entities = [ComicDbItem::class], version = 1)
abstract class ComicDB : RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: ComicDB? = null

        fun getDatabase(context: Context): ComicDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ComicDB::class.java,
                    "comics_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

    abstract fun comicDao(): ComicDao
}
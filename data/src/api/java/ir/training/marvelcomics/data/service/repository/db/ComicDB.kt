package ir.training.marvelcomics.data.service.repository.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.training.marvelcomics.data.service.repository.db.dao.ComicDao

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

    abstract fun userDao(): ComicDao
}
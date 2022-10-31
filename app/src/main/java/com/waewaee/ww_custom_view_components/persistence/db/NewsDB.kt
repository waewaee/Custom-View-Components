package com.waewaee.ww_custom_view_components.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.waewaee.ww_custom_view_components.data.vos.NewsVO
import com.waewaee.ww_custom_view_components.persistence.daos.NewsDao

@Database(entities = [NewsVO::class], version = 7, exportSchema = false)
abstract class NewsDB : RoomDatabase() {
    companion object {
        val DB_NAME = "PADC_NEWS_X.DB"
        var dbInstance: NewsDB? = null

        fun getDBInstance(context: Context): NewsDB {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, NewsDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            val i = dbInstance
            return i!!
        }
    }

    abstract fun newsDao(): NewsDao
}
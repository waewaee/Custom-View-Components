package com.waewaee.ww_custom_view_components.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.waewaee.ww_custom_view_components.data.vos.NewsVO

@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    fun getAllNews(): LiveData<List<NewsVO>>

    @Query("SELECT * FROM news WHERE id = :noteId")
    fun getNewsById(noteId: Int) : LiveData<NewsVO>

    @Query("DELETE FROM news")
    fun deleteAll()

    @Delete
    fun deleteNews(note: NewsVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(noteVO: NewsVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllNews(news: List<NewsVO>)
}
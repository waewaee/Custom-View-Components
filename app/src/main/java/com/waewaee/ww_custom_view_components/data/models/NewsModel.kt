package com.waewaee.ww_custom_view_components.data.models

import androidx.lifecycle.LiveData
import com.waewaee.ww_custom_view_components.data.vos.NewsVO
import io.reactivex.Observable

interface NewsModel {
    fun getAllNews(onError: (String) -> Unit) : LiveData<List<NewsVO>>

    fun getAllNewsFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getNewsById(newsId: Int) : LiveData<NewsVO>
}
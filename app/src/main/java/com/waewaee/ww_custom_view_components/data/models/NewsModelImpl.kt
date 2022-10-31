package com.waewaee.ww_custom_view_components.data.models

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.waewaee.ww_custom_view_components.data.vos.NewsVO
import com.waewaee.ww_custom_view_components.utils.DUMMY_ACCESS_TOKEN
import com.waewaee.ww_custom_view_components.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object NewsModelImpl : NewsModel, BaseModel() {

    override fun getAllNews(onError: (String) -> Unit): LiveData<List<NewsVO>> {
        return mTheDB.newsDao()
            .getAllNews()
    }

    @SuppressLint("CheckResult")
    override fun getAllNewsFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mNewsApi
            .getAllNews(DUMMY_ACCESS_TOKEN)
            .map { it.data?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mTheDB.newsDao().insertAllNews(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }


    override fun getNewsById(newsId: Int): LiveData<NewsVO> {

        return mTheDB.newsDao().getNewsById(newsId)
    }
}
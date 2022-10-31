package com.waewaee.ww_custom_view_components.data.models

import android.content.Context
import com.waewaee.ww_custom_view_components.network.NewsApi
import com.waewaee.ww_custom_view_components.persistence.db.NewsDB
import com.waewaee.ww_custom_view_components.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {

    protected var mNewsApi: NewsApi
    protected lateinit var mTheDB: NewsDB

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mNewsApi = retrofit.create(NewsApi::class.java)
    }

    fun initDatabase(context: Context) {
        mTheDB = NewsDB.getDBInstance(context)
    }
}
package com.waewaee.ww_custom_view_components.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.waewaee.ww_custom_view_components.R
import com.waewaee.ww_custom_view_components.data.models.NewsModel
import com.waewaee.ww_custom_view_components.data.models.NewsModelImpl
import com.waewaee.ww_custom_view_components.data.vos.NewsVO
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetailActivity : BaseActivity() {

    companion object {

        const val NEWS_ID_EXTRA = "News Id Extra"

        fun newItent(context: Context, newsId : Int): Intent {
            val intent =  Intent(context, NewsDetailActivity::class.java)
            intent.putExtra(NEWS_ID_EXTRA, newsId)
            return intent
        }
    }

    private var mNewsModel : NewsModel = NewsModelImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val newsId = intent.getIntExtra(NEWS_ID_EXTRA, 0)
        mNewsModel.getNewsById(newsId)
            ?.observe(this, Observer {
                bindData(it)
            })
    }

    private fun bindData(news : NewsVO){
        tvNewsHeadLine.text = news.title

        Glide.with(this)
            .load(news.heroImage)
            .into(ivNewsImage)

        tvNewsDescription.text = news.description

        news.comments.forEach {
            Log.e("ccc", it.commentMessage)
        }
    }
}

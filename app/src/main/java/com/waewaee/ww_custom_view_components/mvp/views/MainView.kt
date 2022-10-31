package com.waewaee.ww_custom_view_components.mvp.views

import com.waewaee.ww_custom_view_components.data.vos.NewsVO
import com.waewaee.ww_custom_view_components.mvp.views.BaseView

interface MainView : BaseView {
    fun displayNewsList(newsList: List<NewsVO>)
    fun navigateToNewsDetails(newsId: Int)
    fun displayEmptyView()
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
}
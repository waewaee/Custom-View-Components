package com.waewaee.ww_custom_view_components.mvp.views

import com.waewaee.ww_custom_view_components.data.vos.NewsVO
import com.waewaee.ww_custom_view_components.mvp.views.BaseView

interface NewsDetailsView : BaseView {
    fun displayNewsDetails(news: NewsVO)
}
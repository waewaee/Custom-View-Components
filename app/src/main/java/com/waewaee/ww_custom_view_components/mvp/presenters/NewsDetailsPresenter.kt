package com.waewaee.ww_custom_view_components.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.waewaee.ww_custom_view_components.mvp.views.NewsDetailsView

interface NewsDetailsPresenter : BasePresenter<NewsDetailsView> {
    fun onUiReady(lifeCycleOwner: LifecycleOwner, newsId : Int)
}
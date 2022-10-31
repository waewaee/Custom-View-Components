package com.waewaee.ww_custom_view_components.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.waewaee.ww_custom_view_components.mvp.views.NewsDetailsView

class NewsDetailsPresenterImpl : NewsDetailsPresenter, AbstractBasePresenter<NewsDetailsView>() {
    override fun onUiReady(lifeCycleOwner: LifecycleOwner, newsId: Int) {

    }
}
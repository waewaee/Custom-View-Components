package com.waewaee.ww_custom_view_components.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.waewaee.ww_custom_view_components.delegates.NewsItemDelegate
import com.waewaee.ww_custom_view_components.mvp.views.MainView

interface MainPresenter : NewsItemDelegate, BasePresenter<MainView> {
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
}

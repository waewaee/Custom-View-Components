package com.waewaee.ww_custom_view_components.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.waewaee.ww_custom_view_components.delegates.NewsItemDelegate
import com.waewaee.ww_custom_view_components.mvp.views.MainView
import com.waewaee.ww_custom_view_components.veiws.viewpods.EmptyViewPod

interface MainPresenter : NewsItemDelegate, BasePresenter<MainView>, EmptyViewPod.Delegate {
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
}

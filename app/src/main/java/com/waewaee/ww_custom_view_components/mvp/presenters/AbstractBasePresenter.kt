package com.waewaee.ww_custom_view_components.mvp.presenters

import androidx.lifecycle.ViewModel
import com.waewaee.ww_custom_view_components.mvp.views.BaseView

abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel() {
    var mView: T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}
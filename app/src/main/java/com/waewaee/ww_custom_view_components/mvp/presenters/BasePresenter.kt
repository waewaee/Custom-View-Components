package com.waewaee.ww_custom_view_components.mvp.presenters

import com.waewaee.ww_custom_view_components.mvp.views.BaseView


interface BasePresenter<T : BaseView> {

    fun initPresenter(view: T)

}
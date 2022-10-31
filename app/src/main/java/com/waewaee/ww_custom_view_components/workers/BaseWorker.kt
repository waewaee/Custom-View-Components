package com.waewaee.ww_custom_view_components.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.waewaee.ww_custom_view_components.data.models.NewsModel
import com.waewaee.ww_custom_view_components.data.models.NewsModelImpl

abstract class BaseWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    val mNewsModel : NewsModel = NewsModelImpl
}
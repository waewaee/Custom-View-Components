package com.waewaee.ww_custom_view_components.workers

import android.content.Context
import androidx.work.WorkerParameters
import com.waewaee.ww_custom_view_components.workers.BaseWorker

class GetNewsWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams) {

    override fun doWork(): Result {
        var result = Result.failure()

        mNewsModel.getAllNewsFromApiAndSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onError = {
                result = Result.failure()
            }
        )
        return result
    }
}
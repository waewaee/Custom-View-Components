package com.waewaee.ww_custom_view_components.network.dataagents

import com.waewaee.ww_custom_view_components.data.vos.NewsVO

interface NewsDataAgent {
    fun getAllNews(
        accessToken : String,
        onSuccess: (List<NewsVO>) -> Unit,
        onFailure: (String) -> Unit)
}
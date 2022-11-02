package com.waewaee.ww_custom_view_components.delegates

import com.waewaee.ww_custom_view_components.veiws.viewpods.ReactionViewPod

interface NewsItemDelegate: ReactionViewPod.Delegate {
    fun onTapNewsItem(newsId : Int)
}
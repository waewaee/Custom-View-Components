package com.waewaee.ww_custom_view_components.veiws.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.waewaee.ww_custom_view_components.data.vos.NewsVO
import com.waewaee.ww_custom_view_components.delegates.NewsItemDelegate
import kotlinx.android.synthetic.main.item_news.view.*

class NewsViewHolder(itemView: View, delegate: NewsItemDelegate) :
  BaseNewsViewHolder(itemView) {

    init {

        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapNewsItem(it.id)
            }
        }
    }

    override fun bindData(data: NewsVO) {
        mData = data
        Glide.with(itemView.context)
            .load(data.heroImage)
            .into(itemView.ivNewsImage)
        itemView.tvNewsHeadLine.text = data.title
    }




}
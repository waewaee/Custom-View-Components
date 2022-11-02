package com.waewaee.ww_custom_view_components.veiws.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.waewaee.ww_custom_view_components.data.vos.NewsVO
import com.waewaee.ww_custom_view_components.delegates.NewsItemDelegate
import com.waewaee.ww_custom_view_components.veiws.viewpods.ReactionViewPod
import kotlinx.android.synthetic.main.item_news.view.*

class NewsViewHolder(itemView: View, private val delegate: NewsItemDelegate) :
  BaseNewsViewHolder(itemView) {

    private val mViewPodReaction = itemView.viewPodReaction as ReactionViewPod

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

        mViewPodReaction.bindData(data)
        mViewPodReaction.setDelegate(delegate)
    }




}
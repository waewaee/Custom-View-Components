package com.waewaee.ww_custom_view_components.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.waewaee.ww_custom_view_components.R
import com.waewaee.ww_custom_view_components.adapters.BaseRecyclerAdapter
import com.waewaee.ww_custom_view_components.data.vos.NewsVO
import com.waewaee.ww_custom_view_components.delegates.NewsItemDelegate
import com.waewaee.ww_custom_view_components.veiws.viewholder.BaseNewsViewHolder
import com.waewaee.ww_custom_view_components.veiws.viewholder.NewsSmallViewHolder
import com.waewaee.ww_custom_view_components.veiws.viewholder.NewsViewHolder

/**
 * Created by Ye Pyae Sone Tun
 * on 2020-01-18.
 */

class NewsListAdapter(delegate: NewsItemDelegate) : BaseRecyclerAdapter<BaseNewsViewHolder, NewsVO>(){

    val mDelegate: NewsItemDelegate = delegate
    val VIEW_TYPE_LARGE = 2244
    val VIEW_TYPE_SMALL = 1122

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseNewsViewHolder {

        when (viewType) {
            VIEW_TYPE_LARGE -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
                return NewsViewHolder(view, mDelegate)
            }
            VIEW_TYPE_SMALL -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_news_smalll, parent, false)
                return NewsSmallViewHolder(view, mDelegate)
            }
            else -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
                return NewsViewHolder(view, mDelegate)
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        when {
            position % 3 == 0 -> {
                return VIEW_TYPE_LARGE
            }
            else -> {
                return VIEW_TYPE_SMALL
            }
        }
    }
}
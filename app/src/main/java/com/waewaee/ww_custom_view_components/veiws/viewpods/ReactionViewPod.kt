package com.waewaee.ww_custom_view_components.veiws.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.waewaee.ww_custom_view_components.data.vos.NewsVO
import kotlinx.android.synthetic.main.view_pod_reaction.view.*

class ReactionViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    private var mDelegate: Delegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    fun bindData(data: NewsVO) {
        tvLikedUser.text = data.likedUsers.count().toString()
        tvCommentedUser.text = data.likedUsers.count().toString()
    }

    private fun setUpListener() {
        tvLike.setOnClickListener {
            mDelegate?.onTapLike()
        }

        tvComment.setOnClickListener {
            mDelegate?.onTapComment()
        }

        tvShare.setOnClickListener {
            mDelegate?.onTapShare()
        }
    }

    interface Delegate {

        fun onTapLike()
        fun onTapComment()
        fun onTapShare()
    }
}
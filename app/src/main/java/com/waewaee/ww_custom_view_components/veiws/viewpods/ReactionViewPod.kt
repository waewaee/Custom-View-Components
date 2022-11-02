package com.waewaee.ww_custom_view_components.veiws.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.view_pod_reaction.view.*

class ReactionViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    private fun setUpListener() {
        tvLike.setOnClickListener {

        }

        tvComment.setOnClickListener {

        }

        tvShare.setOnClickListener {

        }
    }
}
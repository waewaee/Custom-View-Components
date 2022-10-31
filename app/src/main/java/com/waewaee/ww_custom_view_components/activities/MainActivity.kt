package com.waewaee.ww_custom_view_components.activities

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.waewaee.ww_custom_view_components.R
import com.waewaee.ww_custom_view_components.adapters.NewsListAdapter
import com.waewaee.ww_custom_view_components.data.vos.NewsVO
import com.waewaee.ww_custom_view_components.mvp.presenters.MainPresenter
import com.waewaee.ww_custom_view_components.mvp.presenters.MainPresenterImpl
import com.waewaee.ww_custom_view_components.mvp.views.MainView
import com.waewaee.ww_custom_view_components.utils.EMPTY_IMAGE_URL
import com.waewaee.ww_custom_view_components.utils.EM_NO_NEWS_AVAILABLE
import com.waewaee.ww_custom_view_components.veiws.viewpods.EmptyViewPod
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainView {

    private lateinit var mAdapter: NewsListAdapter

    private lateinit var viewPodEmpty: EmptyViewPod

    private lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()

        hideEmptyView()
        setUpSwipeRefresh()
        setUpRecyclerView()
        setUpViewPod()
        mPresenter.onUiReady(this)
    }

    override fun displayNewsList(newsList: List<NewsVO>) {
        mAdapter.setNewData(newsList.toMutableList())
    }

    override fun navigateToNewsDetails(newsId: Int) {
        startActivity(NewsDetailActivity.newItent(this, newsId))
    }

    override fun displayEmptyView() {
        showEmptyView()
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpViewPod() {
        viewPodEmpty = vpEmpty as EmptyViewPod
        viewPodEmpty.setEmptyData(EM_NO_NEWS_AVAILABLE, EMPTY_IMAGE_URL)
    }

    private fun setUpSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener {
            mPresenter.onSwipeRefresh(this)
        }
    }

    private fun setUpRecyclerView() {
        mAdapter = NewsListAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvNews.layoutManager = linearLayoutManager
        rvNews.adapter = mAdapter
    }

    private fun showEmptyView() {
        vpEmpty.visibility = View.VISIBLE
    }

    private fun hideEmptyView() {
        vpEmpty.visibility = View.GONE
    }

}

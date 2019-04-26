package com.vtu.base.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.vtu.base.R
import com.vtu.base.commons.GridSpacingItemDecoration
import com.vtu.base.commons.Utilities
import com.vtu.base.viewmodels.BaseRecycleViewViewModel

open class BaseRecycleViewFragment : BaseFragment() {

    var viewModel: BaseRecycleViewViewModel<*>? = null
    lateinit var recycleView : RecyclerView
    var mView: View? = null

    fun getLayoutID() : Int {
        return R.layout.main_fragment
    }

    fun getColumn() :Int {
        return DEFAULT_COLUMN_COUNT
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (mView != null) {
            if (mView!!.parent as ViewGroup != null)
                (mView!!.parent as ViewGroup).removeView(mView)
        } else {
            mView = inflater.inflate(getLayoutID(), container, false)
        }

        recycleView = mView!!.findViewById(R.id.recycleView)
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(getColumn(), StaggeredGridLayoutManager.VERTICAL)
        recycleView.layoutManager = staggeredGridLayoutManager
        recycleView.addItemDecoration(GridSpacingItemDecoration(Utilities.dpToPx(context, 4)))
        recycleView.itemAnimator = DefaultItemAnimator()

        recycleView.adapter = viewModel!!.baseAdapter

        return mView!!
    }

    companion object {

        internal var DEFAULT_COLUMN_COUNT = 3

        fun newInstance(): BaseRecycleViewFragment {
            return BaseRecycleViewFragment()
        }
    }

}
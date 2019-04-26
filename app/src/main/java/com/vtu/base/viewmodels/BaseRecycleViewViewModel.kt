package com.vtu.base.viewmodels

import android.content.Context
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vtu.base.adapter.BaseAdapter
import java.util.ArrayList

typealias Callback = (Any) -> Unit

open class BaseRecycleViewViewModel<T> : BaseViewModel {
    var offset: Int? = null
    var baseAdapter: BaseAdapter<T>
    var itemSources: MutableList<T>

    constructor(context: Context?) : super(context) {
        offset = 0
        itemSources = ArrayList()
        baseAdapter = BaseAdapter(itemSources, context!!)
    }

    override fun getData(vararg callback: Callback) {

    }

    fun refreshData(vararg callback: Callback) {
        this.itemSources = ArrayList()
        this.offset = 0
        itemSources = ArrayList()
        getData(*callback)
    }

    fun loadMoreData(vararg callback: Callback) {
        getData(*callback)
    }

    @BindingAdapter("data")
    fun setData(recycleView: RecyclerView, data: List<T>) {
        if (recycleView.adapter is BaseAdapter<*>) {
            (recycleView.adapter as BaseAdapter<T>).setData(data)
            (recycleView.adapter as BaseAdapter<T>).notifyDataSetChanged()
        }
    }
}

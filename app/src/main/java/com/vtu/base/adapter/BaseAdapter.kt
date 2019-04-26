package com.vtu.base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.vtu.base.models.BaseModel
import java.util.ArrayList

class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder> {
    var context: Context
    private var onClickListener: ClickListener? = null
    var list: List<T>

    constructor(list: List<T>, context: Context) {
        this.list = list
        this.context = context
    }

    fun setData(list: List<T>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun getOnClickListener(): ClickListener? {
        return onClickListener
    }

    fun setOnClickListener(onClickListener: ClickListener) {
        this.onClickListener = onClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            layoutInflater, viewType, parent, false
        )

        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder,
        position: Int
    ) {
        val obj = getObjForPosition(position) as BaseModel
        holder.bind(obj)
        /*layout for item*/
        val layoutParams = holder.itemView.layoutParams
        if (layoutParams != null && layoutParams is StaggeredGridLayoutManager.LayoutParams) {
            if (obj.isFullSpan()) {
                layoutParams.isFullSpan = true
            } else {
                layoutParams.isFullSpan = false
            }
        }
        /*handle click*/
        holder.binding()!!.root.setOnClickListener(View.OnClickListener { view ->
            if (getOnClickListener() == null) {
                obj.onSelected(view, context)
            } else {
                onClickListener!!.onItemClick(position, holder.binding()!!.root)
            }
        })
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }


    interface ClickListener {
        fun onItemClick(position: Int, v: View)
    }

    fun getObjForPosition(position: Int): T {
        return list.get(position)
    }

    fun getLayoutIdForPosition(position: Int): Int {
        val model = list[position] as BaseModel
        return model.getLayoutID()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}


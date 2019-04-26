package com.vtu.base.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.vtu.base.models.BaseModel

class BaseViewHolder : RecyclerView.ViewHolder {
    var binding : ViewDataBinding? = null

    fun binding() : ViewDataBinding? {
        return binding
    }

    constructor(binding: ViewDataBinding) : super(binding.root) {
        this.binding = binding
    }

    fun bind(obj: BaseModel) {
        binding!!.setVariable(com.vtu.base.BR.obj, obj)
        binding!!.executePendingBindings()
    }
}
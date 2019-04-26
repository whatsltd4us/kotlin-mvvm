package com.vtu.base.viewmodels

import android.content.Context
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import com.vtu.base.BR
import com.vtu.base.networking.APIHelper
import com.vtu.base.networking.IRequest

abstract class BaseViewModel : BaseObservable {
    protected var context: Context? = null
    private var isBusy = false
    private var isDisconnect = false

    internal var baseRequest: IRequest? = null

    @Bindable
    fun isBusy(): Boolean {
        return isBusy
    }

    fun setBusy(busy: Boolean) {
        isBusy = busy
        notifyPropertyChanged(BR.busy)
    }

    constructor() {

    }

    constructor(context: Context?) {
        this.context = context!!
        baseRequest = APIHelper.request
        getData()
    }

    @BindingAdapter("goneUnless")
    fun setVisibility(view: View, isBusy: Boolean) {
        view.visibility = if (isBusy) View.VISIBLE else View.GONE
    }

    fun isDisconnect(): Boolean {
        return isDisconnect
    }

    fun setDisconnect(disconnect: Boolean) {
        isDisconnect = disconnect
    }

    abstract fun getData(vararg callback: Callback)

}
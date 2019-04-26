package com.vtu.base.viewmodels

import android.content.Context
import androidx.databinding.BaseObservable
import com.vtu.base.adapter.BaseAdapter
import java.util.ArrayList

class MainViewModel : BaseViewModel {

    companion object {
        val instance = MainViewModel()
    }

    constructor() :super() {

    }

    constructor(context: Context?) : super(context) {

    }

    override fun getData(vararg callback: Callback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    // TODO: Implement the ViewModel
}

package com.vtu.base.models

import android.content.Context
import android.view.View
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

open class BaseResponse : BaseModel() {
    override fun getLayoutID(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isFullSpan(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSelected(view: View, context: Context) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class Response<T> : BaseResponse() {
    @SerializedName("results")
    @Expose
    var results: ArrayList<T>? = null
}

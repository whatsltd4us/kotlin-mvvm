package com.vtu.base.models

import android.content.Context
import android.view.View
import androidx.databinding.BaseObservable
import java.io.Serializable

abstract class BaseModel : BaseObservable(), Serializable {

    abstract fun getLayoutID() : Int

    abstract fun isFullSpan() : Boolean

    abstract fun onSelected(view: View, context: Context)
}

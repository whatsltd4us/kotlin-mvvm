package com.vtu.base

import android.app.Activity
import android.app.Application

class BaseApplication : Application() {

    private var mCurrentActivity: Activity? = null
    fun getCurrentActivity(): Activity? {
        return mCurrentActivity
    }

    fun setCurrentActivity(mCurrentActivity: Activity?) {
        this.mCurrentActivity = mCurrentActivity
    }

    override fun onCreate() {
        super.onCreate()
    }

}

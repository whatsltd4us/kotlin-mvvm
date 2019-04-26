package com.vtu.base.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vtu.base.BaseApplication

class BaseActivity : AppCompatActivity() {
    var baseAppication: BaseApplication? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseAppication = this.applicationContext as BaseApplication
    }

    override fun onResume() {
        super.onResume()
        baseAppication!!.setCurrentActivity(this)
    }

    override fun onPause() {
        clearReferences()
        super.onPause()
    }

    override fun onDestroy() {
        clearReferences()
        super.onDestroy()
    }

    private fun clearReferences() {
        val currActivity = baseAppication!!.getCurrentActivity()
        if (this == currActivity)
            baseAppication!!.setCurrentActivity(null)
    }
}
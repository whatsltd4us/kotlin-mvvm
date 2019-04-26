package com.vtu.base.viewmodels

import android.content.Context
import android.util.Log
import com.vtu.base.models.Repos
import retrofit2.Call

class MainFragmentViewModel : BaseRecycleViewViewModel<Repos> {
    constructor(context: Context?) : super(context) {

    }

    override fun getData(vararg callback: Callback) {
        super.getData(*callback)
        baseRequest!!.getRepos().enqueue(object :
            retrofit2.Callback<List<Repos>> {
            override fun onResponse(call: Call<List<Repos>>, response: retrofit2.Response<List<Repos>>) {
                if (response.isSuccessful()) {
                    itemSources.addAll(response.body()!!)
                    baseAdapter.setData(itemSources)

                    MainViewModel.instance.setBusy(false)

                } else {
                    val statusCode = response.code()
                    // handle request errors depending on status code
                    MainViewModel.instance.setBusy(false)

                }
            }

            override fun onFailure(call: Call<List<Repos>>, t: Throwable) {
                Log.d("", "onFailure: ")
            }
        })
    }
}
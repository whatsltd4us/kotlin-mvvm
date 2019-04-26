package com.vtu.base.networking

import com.vtu.base.models.BaseModel
import com.vtu.base.models.Repos
import com.vtu.base.models.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IRequest {
    @GET("users/whatsltd4us/repos")
    fun getRepos(): Call<List<Repos>>
}

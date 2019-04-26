package com.vtu.base.networking

object APIHelper {
    val BASE_URL = "https://api.github.com/"

    val request: IRequest
        get() = RetrofitClient.getClient(BASE_URL)!!.create(IRequest::class.java)
}

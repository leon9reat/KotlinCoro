package com.medialink.kotlincoro.network

import com.medialink.kotlincoro.Users
import retrofit2.Response
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getUserAsync(): Response<Users>
}
package com.lyons.usat.gas.data.network.user

import com.google.gson.JsonObject
import com.lyons.usat.gas.data.model.UserModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiClient {
    @POST("users/login")
    suspend fun login(@Body requestBody: JsonObject):Response<UserModel>
}
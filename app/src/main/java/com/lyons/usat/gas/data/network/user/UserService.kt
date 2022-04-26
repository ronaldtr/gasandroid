package com.lyons.usat.gas.data.network.user

import com.google.gson.JsonObject
import com.lyons.usat.gas.data.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserService @Inject constructor(private val api: UserApiClient){

    suspend fun login(obj: JsonObject): UserModel {
        return withContext(Dispatchers.IO) {
            val response = api.login(obj)
            response.body() ?: UserModel()
        }
    }
}
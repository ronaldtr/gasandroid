package com.lyons.usat.gas.data.repository

import com.google.gson.JsonObject
import com.lyons.usat.gas.data.model.UserModel
import com.lyons.usat.gas.data.model.provider.UserProvider
import com.lyons.usat.gas.data.network.user.UserService
import javax.inject.Inject

class UserRepository @Inject constructor(private val api : UserService, private val userProvider: UserProvider){

    suspend fun login(obj: JsonObject):UserModel {
        val response = api.login(obj)
        userProvider.login = response
        return response
    }
}
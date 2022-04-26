package com.lyons.usat.gas.domain

import com.google.gson.JsonObject
import com.lyons.usat.gas.data.model.UserModel
import com.lyons.usat.gas.data.repository.UserRepository
import javax.inject.Inject

class UserUseCase @Inject constructor(private val repository: UserRepository) {

    suspend operator fun invoke(obj: JsonObject): UserModel? = repository.login(obj)

}
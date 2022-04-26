package com.lyons.usat.gas.data.model.provider

import com.lyons.usat.gas.data.model.UserModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserProvider @Inject constructor(){

    var login:UserModel = UserModel()
}
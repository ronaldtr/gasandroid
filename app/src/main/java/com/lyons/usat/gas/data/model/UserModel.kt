package com.lyons.usat.gas.data.model

import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("id") val id: Long? = null,
    @SerializedName("name") val usuario: String? = null,
    @SerializedName("menu") val menu: List<MenuModel>? = null
)

data class UserModel (
    val code: Int? = null,
    val data: DataModel? = null
)
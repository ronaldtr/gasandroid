package com.lyons.usat.gas.data.model

import com.google.gson.annotations.SerializedName

data class MenuModel(
    @SerializedName("id") val id: Long,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("accion") val accion: String,
    @SerializedName("icono") val icono: String,
    @SerializedName("menus") val menus: List<MenuModel>
)
package com.lyons.usat.gas.data.model

import com.google.gson.annotations.SerializedName

data class SucursalModel(
    @SerializedName("id") val id: Long,
    @SerializedName("razonSocial") val razonSocial: String,
    @SerializedName("direccion") val direccion: String
)



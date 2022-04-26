package com.lyons.usat.gas.data.network.sucursal

import com.lyons.usat.gas.data.model.SucursalModel
import retrofit2.Response
import retrofit2.http.GET

interface SucursalApiClient {
    @GET("sucursals")
    suspend fun getAllSucursals():Response<List<SucursalModel>>
}
package com.lyons.usat.gas.data.network.sucursal

import com.lyons.usat.gas.data.model.SucursalModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SucursalService @Inject constructor(private val api: SucursalApiClient){

    suspend fun getAllSucursals(): List<SucursalModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllSucursals()
            response.body() ?: emptyList()
        }
    }
}
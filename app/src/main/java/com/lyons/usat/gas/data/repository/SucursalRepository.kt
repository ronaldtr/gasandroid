package com.lyons.usat.gas.data.repository

import com.lyons.usat.gas.data.model.SucursalModel
import com.lyons.usat.gas.data.model.provider.SucursalProvider
import com.lyons.usat.gas.data.network.sucursal.SucursalService
import javax.inject.Inject

class SucursalRepository @Inject constructor(private val api : SucursalService, private val sucursalProvider: SucursalProvider){

    suspend fun getAllSucursals():List<SucursalModel> {
        val response = api.getAllSucursals()
        sucursalProvider.sucursals = response
        return response
    }
}
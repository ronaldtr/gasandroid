package com.lyons.usat.gas.data.model.provider

import com.lyons.usat.gas.data.model.SucursalModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SucursalProvider @Inject constructor(){

    var sucursals:List<SucursalModel> = emptyList()
}
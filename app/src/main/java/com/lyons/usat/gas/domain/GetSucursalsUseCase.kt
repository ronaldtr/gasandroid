package com.lyons.usat.gas.domain

import com.lyons.usat.gas.data.repository.SucursalRepository
import com.lyons.usat.gas.data.model.SucursalModel
import javax.inject.Inject

class GetSucursalsUseCase @Inject constructor(private val repository: SucursalRepository) {

    suspend operator fun invoke(): List<SucursalModel>? = repository.getAllSucursals()

}
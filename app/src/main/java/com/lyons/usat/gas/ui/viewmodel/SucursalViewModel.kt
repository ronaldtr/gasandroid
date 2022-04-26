package com.lyons.usat.gas.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lyons.usat.gas.data.model.SucursalModel
import com.lyons.usat.gas.domain.GetSucursalsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SucursalViewModel @Inject constructor(
    private val getSucursalsUseCase: GetSucursalsUseCase
) : ViewModel() {

    val sucursalModel = MutableLiveData<SucursalModel?>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getSucursalsUseCase()
            if (!result.isNullOrEmpty()) {
                sucursalModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }
}
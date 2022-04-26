package com.lyons.usat.gas.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonObject
import com.lyons.usat.gas.data.model.UserModel
import com.lyons.usat.gas.domain.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userUseCase: UserUseCase
) : ViewModel() {

    val userModel = MutableLiveData<UserModel?>()
    //private val isLoading = MutableLiveData<Boolean>()

    fun login(obj: JsonObject) {
        viewModelScope.launch {
            //isLoading.postValue(true)
            val result = userUseCase(obj)
            if (result != null) {
                userModel.postValue(result)
                //isLoading.postValue(false)
            }
        }
    }
}
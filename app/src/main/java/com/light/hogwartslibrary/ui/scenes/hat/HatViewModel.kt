package com.light.hogwartslibrary.ui.scenes.hat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HatViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>().apply { value = false }
    private val _facultyName = MutableLiveData<String>().apply { value = "" }

    val isLoading: LiveData<Boolean> = _isLoading
    val facultyName: LiveData<String> = _facultyName


    fun getFacultyName(name: String, surname: String) {

        viewModelScope.launch {
            _isLoading.postValue(true)
        }
    }

}
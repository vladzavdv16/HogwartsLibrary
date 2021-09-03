package com.light.hogwartslibrary.ui.scenes.hat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.light.hogwartslibrary.domain.repository.HatRepository
import com.light.hogwartslibrary.domain.repository.HatRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HatViewModel : ViewModel() {

    private var hatRepository: HatRepository = HatRepositoryImpl()

    private val _username = MutableLiveData<String>().apply { value = "" }
    private val _isLoading = MutableLiveData<Boolean>().apply { value = false }
    private val _facultyName = MutableLiveData<String>().apply { value = "" }

    val isLoading: LiveData<Boolean> = _isLoading
    val facultyName: LiveData<String> = _facultyName

    fun applyUserName(name: String) {
        _username.postValue(name)
    }

    fun getFacultyName() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            withContext(Dispatchers.IO) {
                _facultyName.postValue(
                    hatRepository.generateFaculty(
                        username = _username.value ?: ""
                    ).name
                )
                _isLoading.postValue(false)
            }
        }
    }

}
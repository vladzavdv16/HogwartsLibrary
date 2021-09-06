package com.light.hogwartslibrary.ui.scenes.teachers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.light.hogwartslibrary.domain.repository.TeachersRepositoryImpl
import com.light.hogwartslibrary.ui.scenes.teachers.adapter.TeachersCellModel
import com.light.hogwartslibrary.ui.scenes.teachers.adapter.mapToUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TeachersViewModel : ViewModel() {

    private val repository = TeachersRepositoryImpl()

    private val _students = MutableLiveData<List<TeachersCellModel>>().apply {
        value = ArrayList()
    }

    private val _isLoading = MutableLiveData<Boolean>().apply {
        value = false
    }

    val teachersCell: LiveData<List<TeachersCellModel>> = _students
    val isLoading: LiveData<Boolean> = _isLoading


    fun fetchStudents() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            withContext(Dispatchers.Default) {
                val students = repository.fetchTeachers()
                _isLoading.postValue(false)
                _students.postValue(students.map {
                    it.mapToUI()
                })
            }
        }
    }
}
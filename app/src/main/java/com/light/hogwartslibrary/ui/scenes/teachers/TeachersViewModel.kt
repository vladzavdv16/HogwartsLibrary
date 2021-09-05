package com.light.hogwartslibrary.ui.scenes.teachers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.light.hogwartslibrary.domain.repository.StudentRepositoryImpl
import com.light.hogwartslibrary.ui.scenes.teachers.adapter.TeachersCellModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TeachersViewModel : ViewModel() {

    private val repository = StudentRepositoryImpl()

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
                val students = repository.fetchStudent()
                _isLoading.postValue(false)
                _students.postValue(students.map {
                    TeachersCellModel(
                        id = it.id,
                        name = "${it.name} ${it.secondName}",
                        facultyName = it.facultyName
                    )
                })
            }
        }
    }
}
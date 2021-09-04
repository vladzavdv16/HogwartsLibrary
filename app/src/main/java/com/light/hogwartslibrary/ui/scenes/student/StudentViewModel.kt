package com.light.hogwartslibrary.ui.scenes.student

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.light.hogwartslibrary.domain.repository.StudentRepositoryImpl
import com.light.hogwartslibrary.ui.scenes.student.adapter.StudentsCellModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentViewModel : ViewModel() {

    private val repository = StudentRepositoryImpl()

    private val _students = MutableLiveData<List<StudentsCellModel>>().apply {
        value = ArrayList()
    }

    private val _isLoading = MutableLiveData<Boolean>().apply {
        value = false
    }

    val studentsCell: LiveData<List<StudentsCellModel>> = _students
    val isLoading: LiveData<Boolean> = _isLoading


    fun fetchStudents() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            withContext(Dispatchers.Default) {
                val students = repository.fetchStudent()
                _isLoading.postValue(false)
                _students.postValue(students.map {
                    StudentsCellModel(
                        id = it.id,
                        name = "${it.name} ${it.secondName}",
                        facultyName = it.facultyName
                    )
                })
            }
        }
    }
}
package com.light.hogwartslibrary.ui.scenes.students

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.light.hogwartslibrary.domain.repository.StudentsRepositoryImpl
import com.light.hogwartslibrary.ui.scenes.students.adapter.StudentsCellModel
import com.light.hogwartslibrary.ui.scenes.students.adapter.mapToUI
import com.light.hogwartslibrary.ui.scenes.teachers.adapter.mapToUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentsViewModel : ViewModel() {

    private val studentsRepo = StudentsRepositoryImpl()

    private val _students = MutableLiveData<MutableList<StudentsCellModel>>().apply {
        value = mutableListOf()
    }

    private val _filters = MutableLiveData<MutableList<String>>().apply {
        value = mutableListOf()
    }
    private val _studentsDisplay = MutableLiveData<MutableList<StudentsCellModel>>().apply {
        value = ArrayList()
    }
    val studentsDisplay: LiveData<MutableList<StudentsCellModel>> = _studentsDisplay

    init {
        _studentsDisplay.postValue(_students.value ?: ArrayList())
        fetchStudents()
    }

    private fun fetchStudents() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                val students = studentsRepo.getAllStudents()
                _students.postValue(students.map {
                    it.mapToUI()
                }.toMutableList())
            }
        }

    }

    fun pressFilter(faculty: String, isSelected: Boolean) {
        if (isSelected) {
            _filters.value?.add(faculty)
        } else {
            _filters.value?.remove(faculty)
        }

        if (_filters.value?.isEmpty() == true) {
            _studentsDisplay.postValue(_students.value ?: ArrayList())
            return
        }

        _studentsDisplay.postValue(_students.value?.filter {
            _filters.value?.contains(it.facultyName) ?: false
        }?.toMutableList())
    }
}
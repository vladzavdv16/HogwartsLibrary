package com.light.hogwartslibrary.ui.scenes.students

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.light.hogwartslibrary.ui.scenes.students.adapter.StudentsCellModel

class StudentsViewModel : ViewModel() {

    private val _students = MutableLiveData<MutableList<StudentsCellModel>>().apply {
        value = mutableListOf(
            StudentsCellModel(name = "Harry Potter", facultyName = "Griffindor"),
            StudentsCellModel(name = "Ronald Whisley", facultyName = "Griffindor"),
            StudentsCellModel(name = "Drako Malfoy", facultyName = "Slytherin"),
            StudentsCellModel(name = "Sedric Diggori", facultyName = "Ravenclaw"),
            StudentsCellModel(name = "Harry Potter", facultyName = "Griffindor"),
            StudentsCellModel(name = "Ronald Whisley", facultyName = "Griffindor"),
            StudentsCellModel(name = "Drako Malfoy", facultyName = "Slytherin"),
            StudentsCellModel(name = "Sedric Diggori", facultyName = "Ravenclaw")
        )
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
    }

    fun pressFilter(faculty: String, isSelected: Boolean) {
        if (isSelected) {
            _filters.value?.add(faculty)
        } else {
            _filters.value?.remove(faculty)
        }

        if (_filters.value?.isEmpty()  == true) {
            _studentsDisplay.postValue(_students.value ?: ArrayList())
            return
        }

        _studentsDisplay.postValue(_students.value?.filter {
            _filters.value?.contains(it.facultyName) ?: false
        }?.toMutableList())
    }
}
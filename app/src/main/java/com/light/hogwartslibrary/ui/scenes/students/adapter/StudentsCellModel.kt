package com.light.hogwartslibrary.ui.scenes.students.adapter

import com.light.hogwartslibrary.domain.models.StudentsModel

data class StudentsCellModel(
    val name: String,
    val facultyName: String
)

fun StudentsModel.mapToUI(): StudentsCellModel {
    return StudentsCellModel(name = this.name, facultyName = this.facultyName)
}
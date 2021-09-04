package com.light.hogwartslibrary.domain.repository

import com.light.hogwartslibrary.domain.models.StudentModel
import kotlinx.coroutines.delay

class StudentRepositoryImpl : StudentRepository {
    override suspend fun fetchStudent(): List<StudentModel> {
        delay(2000)
        return listOf(
            StudentModel(id = 0, name = "Harry", secondName = "Potter", facultyName = "Griffindor"),
            StudentModel(id = 0, name = "Ronald", secondName = "Whisley", facultyName = "Griffindor"),
            StudentModel(id = 0, name = "Drako", secondName = "Malfoy", facultyName = "Slytherin"),
            StudentModel(id = 0, name = "Sedric", secondName = "Diggori", facultyName = "Ravenclaw"))
    }
}
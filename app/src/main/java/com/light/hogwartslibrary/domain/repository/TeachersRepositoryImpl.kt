package com.light.hogwartslibrary.domain.repository

import com.light.hogwartslibrary.domain.models.TeachersModel
import kotlinx.coroutines.delay

class TeachersRepositoryImpl : TeachersRepository {
    override suspend fun fetchStudent(): List<TeachersModel> {
        delay(2000)
        return listOf(
            TeachersModel(id = 0, name = "Harry", secondName = "Potter", facultyName = "Griffindor"),
            TeachersModel(id = 0, name = "Ronald", secondName = "Whisley", facultyName = "Griffindor"),
            TeachersModel(id = 0, name = "Drako", secondName = "Malfoy", facultyName = "Slytherin"),
            TeachersModel(id = 0, name = "Sedric", secondName = "Diggori", facultyName = "Ravenclaw"))
    }
}
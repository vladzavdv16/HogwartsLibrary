package com.light.hogwartslibrary.domain.repository

import com.light.hogwartslibrary.domain.models.StudentsModel

interface StudentsRepository {

    suspend fun getAllStudents(): List<StudentsModel>

}
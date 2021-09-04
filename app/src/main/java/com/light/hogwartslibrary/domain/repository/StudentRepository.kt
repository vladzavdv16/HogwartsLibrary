package com.light.hogwartslibrary.domain.repository

import com.light.hogwartslibrary.domain.models.StudentModel

interface StudentRepository {

    suspend fun fetchStudent(): List<StudentModel>
}
package com.light.hogwartslibrary.domain.repository

import com.light.hogwartslibrary.domain.models.TeachersModel

interface TeachersRepository {

    suspend fun fetchTeachers(): List<TeachersModel>
}
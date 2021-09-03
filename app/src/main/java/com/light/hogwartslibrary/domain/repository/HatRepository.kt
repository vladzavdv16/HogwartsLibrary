package com.light.hogwartslibrary.domain.repository

import com.light.hogwartslibrary.domain.models.FacultyModel

interface HatRepository {

    suspend fun generateFaculty(username: String): FacultyModel
}
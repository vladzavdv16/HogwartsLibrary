package com.light.hogwartslibrary.domain.repository

import com.light.hogwartslibrary.domain.models.FacultyModel
import kotlinx.coroutines.delay

class HatRepositoryImpl : HatRepository {
    override suspend fun generateFaculty(username: String): FacultyModel {
        delay(2000)

        return if (username == "Harry Potter") {
            FacultyModel("Griffindor")
        } else {
            FacultyModel("Slytherin")
        }
    }
}
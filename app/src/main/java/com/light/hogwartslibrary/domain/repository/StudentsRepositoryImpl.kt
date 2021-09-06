package com.light.hogwartslibrary.domain.repository

import com.light.hogwartslibrary.data.network.RetrofitFactory
import com.light.hogwartslibrary.domain.models.StudentsModel
import com.light.hogwartslibrary.domain.models.mapToDomain

class StudentsRepositoryImpl : StudentsRepository {

    override suspend fun getAllStudents(): List<StudentsModel> {
        return RetrofitFactory.instance.studentsService.getAllStudents()
            .map { it.mapToDomain() }
    }
}
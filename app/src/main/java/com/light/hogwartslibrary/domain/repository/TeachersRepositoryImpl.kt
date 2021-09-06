package com.light.hogwartslibrary.domain.repository

import com.light.hogwartslibrary.data.network.RetrofitFactory
import com.light.hogwartslibrary.domain.models.TeachersModel
import com.light.hogwartslibrary.domain.models.mapToModel


class TeachersRepositoryImpl : TeachersRepository {
    override suspend fun fetchTeachers(): List<TeachersModel> {
        return RetrofitFactory.instance.teachersService.getAllCharacters()
            .map { it.mapToModel() }
    }
}
package com.light.hogwartslibrary.data.service

import com.light.hogwartslibrary.data.models.CharacterRemote
import retrofit2.http.GET

interface StudentsService {

    @GET("api/characters/students")
    suspend fun getAllStudents(): List<CharacterRemote>
}
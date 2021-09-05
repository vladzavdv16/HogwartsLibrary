package com.light.hogwartslibrary.data.service

import com.light.hogwartslibrary.data.models.CharacterRemote
import retrofit2.http.GET

interface CharactersService {

    @GET("api/characters/staff")
    suspend fun getAllCharacters(): List<CharacterRemote>
}
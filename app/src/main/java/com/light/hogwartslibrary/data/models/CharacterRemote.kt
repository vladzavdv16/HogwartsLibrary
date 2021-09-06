package com.light.hogwartslibrary.data.models


import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class CharacterRemote(
    val name: String,
    val species: String,
    val gender: String,
    val house: String,
    val dateOfBirth: String,
    val yearOfBirth: String,
    val ancestry: String,
    val eyeColour: String,
    val hairColour: String,
    @Contextual val wand: Wand,
    val patronus: String,
    val hogwartsStudent: Boolean,
    val hogwartsStaff: Boolean,
    val actor: String,
    val alive: Boolean,
    val image: String
)


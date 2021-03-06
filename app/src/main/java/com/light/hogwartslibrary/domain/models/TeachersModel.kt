package com.light.hogwartslibrary.domain.models

import com.light.hogwartslibrary.data.models.CharacterRemote


data class TeachersModel(
    val name: String,
    val facultyName: String,
    val image: String
)

fun CharacterRemote.mapToModel(): TeachersModel {
    return TeachersModel(name = this.name, facultyName = this.house, image = this.image)
}



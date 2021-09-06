package com.light.hogwartslibrary.domain.models

import com.light.hogwartslibrary.data.models.CharacterRemote

data class StudentsModel(
    val name: String,
    val facultyName: String,
    val image: String
)

fun CharacterRemote.mapToDomain(): StudentsModel {
    return StudentsModel(name = this.name, facultyName = this.house, image = image)
}
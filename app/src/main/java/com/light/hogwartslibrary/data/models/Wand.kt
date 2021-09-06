package com.light.hogwartslibrary.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Wand(
    val wood: String,
    val core: String,
    val length: String
)
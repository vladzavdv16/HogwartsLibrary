package com.light.hogwartslibrary.ui.scenes.teachers.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.light.hogwartslibrary.domain.models.TeachersModel
import java.net.URL


data class TeachersCellModel(
    val name: String,
    val facultyName: String,
    val image: Bitmap
)

fun TeachersModel.mapToUI(): TeachersCellModel {
    return TeachersCellModel(name = this.name, facultyName = this.facultyName, image = downloadFromNetwork(image))
}

fun downloadFromNetwork(source: String): Bitmap {
    val url = URL(source)
    return BitmapFactory.decodeStream(url.openConnection().getInputStream())
}


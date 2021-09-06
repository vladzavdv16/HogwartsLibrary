package com.light.hogwartslibrary.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.light.hogwartslibrary.data.service.StudentsService
import com.light.hogwartslibrary.data.service.TeachersService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class RetrofitFactory {

    companion object {
        val instance = RetrofitFactory()
    }

    private fun okHttpInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(okHttpInterceptor()).build()

    private val retrofitClient: Retrofit = Retrofit.Builder()
        .baseUrl("https://harry-potter.getsandbox.com/")
        .client(okHttpClient)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()

    val teachersService: TeachersService = retrofitClient.create(TeachersService::class.java)
    val studentsService: StudentsService = retrofitClient.create(StudentsService::class.java)
}
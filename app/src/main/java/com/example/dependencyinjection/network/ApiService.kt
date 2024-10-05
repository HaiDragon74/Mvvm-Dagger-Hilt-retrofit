package com.example.dependencyinjection.network

import com.example.dependencyinjection.model.ListMeal
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
        @GET("random.php")
        suspend fun getMeal():ListMeal
}
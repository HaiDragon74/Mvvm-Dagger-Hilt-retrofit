package com.example.dependencyinjection.network

import android.util.Log
import com.example.dependencyinjection.model.ListMeal
import com.example.dependencyinjection.model.Meal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

class MealRepository @Inject constructor(private val apiService: ApiService):MealRepositorySource
{
    override fun getMeal(): Flow<ListMeal> {
        return flow {
            val data =apiService.getMeal()
            emit(data)
        }.flowOn(Dispatchers.IO)
    }

    override fun getUser(): Flow<ListMeal> {
        TODO("Not yet implemented")
    }


}
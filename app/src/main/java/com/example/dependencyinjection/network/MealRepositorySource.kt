package com.example.dependencyinjection.network

import com.example.dependencyinjection.model.ListMeal
import kotlinx.coroutines.flow.Flow

interface MealRepositorySource {
    fun getMeal():Flow<ListMeal>
    fun getUser():Flow<ListMeal>
}
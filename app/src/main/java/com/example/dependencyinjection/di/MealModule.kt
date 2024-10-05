package com.example.dependencyinjection.di

import com.example.dependencyinjection.MyViewModel
import com.example.dependencyinjection.model.ListMeal
import com.example.dependencyinjection.network.ApiService
import com.example.dependencyinjection.network.MealRepository
import com.example.dependencyinjection.network.MealRepositorySource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MealModule {
    @Provides
    fun getRepository():MealRepositorySource{
        return MealRepository(retrofit())
    }
    @Provides
     fun retrofit():ApiService{
        val retrofit= Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api= retrofit.create(ApiService::class.java)
        return api
    }
    @Singleton
    @Provides
    fun viewModel():MyViewModel{
        return MyViewModel(getRepository())
    }
}
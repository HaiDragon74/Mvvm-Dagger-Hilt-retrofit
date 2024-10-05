package com.example.dependencyinjection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.dependencyinjection.model.ListMeal
import com.example.dependencyinjection.network.MealRepository
import com.example.dependencyinjection.network.MealRepositorySource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//class MyViewModelFactory(private val mealRepository: MealRepository) :
//    ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return MyViewModel(mealRepository) as T
//    }
//
//}
@HiltViewModel
class MyViewModel @Inject constructor(private val mealRepository: MealRepositorySource) : ViewModel() {
    private var _listMeal = MutableLiveData<ListMeal>()
    var listMeal: LiveData<ListMeal> = _listMeal

    fun getMeal() {
        viewModelScope.launch {
            mealRepository.getMeal().collect {
                _listMeal.value = it
            }
        }
    }


}
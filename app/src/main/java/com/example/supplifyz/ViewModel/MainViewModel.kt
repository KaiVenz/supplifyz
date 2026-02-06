package com.example.supplifyz.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.supplifyz.Domain.BannerModel
import com.example.supplifyz.Domain.CategoryModel
import com.example.supplifyz.Repository.MainRepository

class MainViewModel : ViewModel(){

    private val repository = MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>>{
        return repository.loadBanner()
    }

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()
    }
}

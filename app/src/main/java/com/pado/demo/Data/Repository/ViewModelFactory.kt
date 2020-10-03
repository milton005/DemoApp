package com.pado.demo.Data.Repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pado.demo.Data.Remote.ApiHelper
import com.pado.demo.UI.HomeActivityViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeActivityViewModel::class.java)) {
            return HomeActivityViewModel(HomeRepository(apiHelper)) as T
        }


        throw IllegalArgumentException("Unknown class name")
    }

}


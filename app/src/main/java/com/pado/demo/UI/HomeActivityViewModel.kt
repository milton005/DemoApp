package com.pado.demo.UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

import com.pado.demo.Data.Repository.HomeRepository
import com.pado.demo.Utils.Resource
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException
class HomeActivityViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    fun getHome(access_token: String,
                        country_code: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = homeRepository.getHome(access_token, country_code)))
        } catch (exception: Exception) {
            if (exception is HttpException) {
                emit(
                    Resource.error(
                        data = null,
                        message = exception.response()?.errorBody()?.string()
                            ?: "Error Occurred!"
                    )
                )
            } else {
                emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            }
        }
    }



}
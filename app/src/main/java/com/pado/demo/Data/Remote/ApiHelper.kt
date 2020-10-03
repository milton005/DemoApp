package com.pado.demo.Data.Remote

open class ApiHelper(private val apiService: ApiService) {

    suspend fun getHome(access_token:String?,country_code:String?) =
        apiService.getHome(access_token,country_code)


}
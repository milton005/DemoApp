package com.pado.demo.Data.Repository

import com.pado.demo.Data.Remote.ApiHelper

class HomeRepository(private val apiHelper: ApiHelper) {
    suspend fun getHome(access_token:String?,country_code:String?)=apiHelper.getHome(access_token,country_code)
}
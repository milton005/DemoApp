package com.pado.demo.Data.Remote

import com.pado.demo.Data.Models.HomeResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @POST("home")
    @FormUrlEncoded
    suspend fun getHome(@Field("access_token")accessToken:String?
    , @Field("country_code")country_code:String?): HomeResponse


}
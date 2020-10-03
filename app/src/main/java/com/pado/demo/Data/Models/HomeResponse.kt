package com.pado.demo.Data.Models

import com.google.gson.annotations.SerializedName

data class HomeResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("httpcode")
	val httpcode: Int? = null,

	@field:SerializedName("status")
	val status: String? = null
)
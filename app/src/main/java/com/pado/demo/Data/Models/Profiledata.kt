package com.pado.demo.Data.Models

import com.google.gson.annotations.SerializedName

data class Profiledata(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("post")
	val post: String? = null,

	@field:SerializedName("address2")
	val address2: String? = null,

	@field:SerializedName("address1")
	val address1: String? = null,

	@field:SerializedName("district")
	val district: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mobile")
	val mobile: String? = null,

	@field:SerializedName("state")
	val state: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
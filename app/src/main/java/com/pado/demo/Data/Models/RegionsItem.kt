package com.pado.demo.Data.Models

import com.google.gson.annotations.SerializedName

data class RegionsItem(

	@field:SerializedName("country_code")
	val countryCode: String? = null,

	@field:SerializedName("country_name")
	val countryName: String? = null,

	@field:SerializedName("country_id")
	val countryId: String? = null
)
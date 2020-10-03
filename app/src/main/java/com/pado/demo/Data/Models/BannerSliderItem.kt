package com.pado.demo.Data.Models

import com.google.gson.annotations.SerializedName

data class BannerSliderItem(

	@field:SerializedName("slider_name")
	val sliderName: String? = null,

	@field:SerializedName("slider_image")
	val sliderImage: String? = null,

	@field:SerializedName("slider_id")
	val sliderId: String? = null
)
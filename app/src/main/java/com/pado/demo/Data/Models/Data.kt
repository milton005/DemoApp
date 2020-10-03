package com.pado.demo.Data.Models

import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("featured")
	val featured: List<FeaturedItem>? = null,

	@field:SerializedName("regions")
	val regions: List<RegionsItem>? = null,

	@field:SerializedName("banner_slider")
	val bannerSlider: List<BannerSliderItem>? = null,

	@field:SerializedName("cartcount")
	val cartcount: Int? = null,

	@field:SerializedName("logo")
	val logo: String? = null,

	@field:SerializedName("categories")
	val categories: List<CategoriesItem>? = null,

	@field:SerializedName("profiledata")
	val profiledata: Profiledata? = null
)
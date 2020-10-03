package com.pado.demo.Data.Models

import com.google.gson.annotations.SerializedName

data class FeaturedItem(

	@field:SerializedName("prd_image")
	val prdImage: String? = null,

	@field:SerializedName("unit")
	val unit: String? = null,

	@field:SerializedName("prd_name")
	val prdName: String? = null,

	@field:SerializedName("price")
	val price: String? = null,

	@field:SerializedName("qty")
	val qty: String? = null,

	@field:SerializedName("rating")
	val rating: String? = null,

	@field:SerializedName("currency")
	val currency: String? = null,

	@field:SerializedName("prd_id")
	val prdId: String? = null
)
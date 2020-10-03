package com.pado.demo.Data.Models

import com.google.gson.annotations.SerializedName

data class CategoriesItem(

	@field:SerializedName("category_image")
	val categoryImage: String? = null,

	@field:SerializedName("category_name")
	val categoryName: String? = null,

	@field:SerializedName("category_id")
	val categoryId: String? = null
)
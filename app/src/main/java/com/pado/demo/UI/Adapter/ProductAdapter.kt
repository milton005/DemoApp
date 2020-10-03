package com.pado.demo.UI.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pado.demo.Data.Models.FeaturedItem
import com.pado.demo.R
import kotlinx.android.synthetic.main.products_iten_row.view.*

class ProductAdapter(val list: List<FeaturedItem>):RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.products_iten_row,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(list.get(position).prdImage).into(holder.itemView.imageProduct)
        list.get(position)?.let {
            holder.itemView.textProductName.text=it.prdName
            holder.itemView.textQty.text=it.qty
            holder.itemView.textPrice.text= """${it.price} AED"""
          if (!it.rating.isNullOrEmpty())
          {
              val v=it.rating.toFloatOrNull()
              v?.let { it1->
                  holder.itemView.ratingBar.rating=it1

              }
          }
        }
    }

    override fun getItemCount(): Int {
       return if (list.isNullOrEmpty())
           0
        else
           list.size
    }
}
package com.pado.demo.UI.Adapter

import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.pado.demo.Data.Models.CategoriesItem
import com.pado.demo.R
import com.pado.demo.Utils.convertDpToPixel
import kotlinx.android.synthetic.main.item_row_category.view.*


class CategoryAdapter(val list:List<CategoriesItem>):RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    var mWidth=0
    var listener: onClickLister?=null
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }
    fun setOnClickListener(listener: onClickLister)
    {
        this.listener=listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val  v=LayoutInflater.from(parent.context).inflate(R.layout.item_row_category, parent, false)
        val metrics: DisplayMetrics = parent.context.getResources().getDisplayMetrics()
        val width = metrics.widthPixels
        val height = metrics.heightPixels
        mWidth=((width- convertDpToPixel(2f,parent.context))/4).toInt()


        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lp=holder.itemView.layoutParams
        lp.width=mWidth
        holder.itemView.layoutParams=lp
        holder.itemView.textCategoryTitle.text=list.get(position).categoryName
        Glide.with( holder.itemView.context).load(list[position].categoryImage).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.itemView.imageView)
        holder.itemView.setOnClickListener{
            listener?.onClicked(list.get(position))
        }
    }

    override fun getItemCount(): Int {
       return if (list.isEmpty())
           0
        else
           list.size
    }
    interface onClickLister{
        fun onClicked(item: CategoriesItem)
    }
}
package com.pado.demo.UI.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.pado.demo.Data.Models.BannerSliderItem
import com.pado.demo.R

import kotlinx.android.synthetic.main.inflate_image.view.*


class SliderAdapter(val context: Context, val list: List<BannerSliderItem>) :PagerAdapter(){
    private var inflater: LayoutInflater? = null


    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return view === `object`
    }

    override fun getCount(): Int {

        return list.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater!!.inflate(R.layout.inflate_image, null)
        Glide.with(context).load(list[position].sliderImage).diskCacheStrategy(DiskCacheStrategy.NONE)
              .into(view.imageView)

        val vp = container as ViewPager
        vp.addView(view, position)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }

}
package com.pado.demo.UI

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.bumptech.glide.Glide
import com.pado.demo.Data.Models.HomeResponse
import com.pado.demo.Data.Remote.ApiHelper
import com.pado.demo.Data.Remote.RetrofitBuilder
import com.pado.demo.Data.Repository.ViewModelFactory
import com.pado.demo.R
import com.pado.demo.UI.Adapter.CategoryAdapter
import com.pado.demo.UI.Adapter.GalleryAdapter
import com.pado.demo.UI.Adapter.ProductAdapter
import com.pado.demo.Utils.Status
import com.pado.demo.Utils.visible
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var spinnerList=ArrayList<String>()
    lateinit var categoryAdapter:CategoryAdapter
    lateinit var productAdapter: ProductAdapter
    lateinit var sliderAdapter: GalleryAdapter
    lateinit var viewModel:HomeActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViewModel()
        getHome()
        initUi()
    }

    private fun initUi() {
        pager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) { /*empty*/
            }

            override fun onPageSelected(position: Int) {
                pageIndicatorView.selection = position
            }

            override fun onPageScrollStateChanged(state: Int) { /*empty*/
            }
        })
    }

    private fun getHome() {
        viewModel?.getHome("752027", "AE").observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        progress.visible(false)
                        processData(resource.data)
                    }
                    Status.ERROR -> {
                        progress.visible(true)
                    }
                    Status.LOADING -> {
                        progress.visible(false)
                    }
                }
            }
        })
    }

    private fun processData(data: HomeResponse?) {
        data?.data?.categories?.let {
            categoryAdapter= CategoryAdapter(it)
            recyclerCategory.adapter=categoryAdapter
        }
        data?.data?.featured?.let {
            productAdapter=ProductAdapter(it)
            recyclerProduct.adapter=productAdapter
        }
        data?.data?.bannerSlider?.let {
            var list=ArrayList<String>()
            it.forEach {
                it.sliderImage?.let { it1->
                    list.add(it1)
                }
            }
            pageIndicatorView.count=list.size
            sliderAdapter=GalleryAdapter(this, list)
            pager.adapter=sliderAdapter
        }
        data?.data?.regions?.let {
            spinnerList.add("Select region")
            it.forEach {
                it.countryName?.let { it2->
                    spinnerList.add(it2)
                }
            }



              val adapter=  ArrayAdapter<String>(
                    this,
                    R.layout.simple_spinner_drop_down_item,
                    spinnerList.toList()
                )
            adapter.setDropDownViewResource(R.layout.simple_spinner_drop_down_item)
            spinner.adapter=adapter


        }
        data?.data?.logo?.let {
            Glide.with(this).load(it).into(imageView)
        }


    }

    private fun setUpViewModel() {
        viewModel =
            ViewModelProviders.of(this, ViewModelFactory(ApiHelper(RetrofitBuilder.apiService)))
                .get(HomeActivityViewModel::class.java)
    }
}
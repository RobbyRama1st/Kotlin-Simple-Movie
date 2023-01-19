package com.sweet.cloves.simplemovie.ui.screen.main.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.sweet.cloves.simplemovie.BuildConfig
import com.sweet.cloves.simplemovie.R
import com.sweet.cloves.simplemovie.data.model.Movie
import com.sweet.cloves.simplemovie.databinding.SliderItemTrendingMovieBinding
import com.sweet.cloves.simplemovie.ui.screen.detail.DialogDetail

class TrendingSliderPagerAdapter(private val context: Context) : PagerAdapter() {

    private var data = ArrayList<Movie>()

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = SliderItemTrendingMovieBinding.inflate(LayoutInflater.from(context), container, false)
        val item = data[position]
        Glide.with(context)
            .load(BuildConfig.IMAGE_URL + item.backdropPath)
//                .apply(requestOptionsCircular(itemView.context))
            .error(R.mipmap.no_image)
            .into(binding.ivMoviePoster)
        binding.tvMovieTitle.text = item.title
        binding.fabPlay.setOnClickListener {
            val args = Bundle()
            item.id?.let { it1 -> args.putInt("MOVIE_ID", it1) }
            val manager: FragmentManager = (context as AppCompatActivity).getSupportFragmentManager()
            DialogDetail.newInstance(args).show(manager, DialogDetail.TAG)
        }
        container.addView(binding.root)
        return binding.root
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    fun setData(trendingList: List<Movie>) {
        data.addAll(trendingList)
        notifyDataSetChanged()
    }
}
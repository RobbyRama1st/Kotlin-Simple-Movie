package com.sweet.cloves.simplemovie.ui.screen.main

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Menu
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.sweet.cloves.simplemovie.BuildConfig
import com.sweet.cloves.simplemovie.R
import com.sweet.cloves.simplemovie.data.model.Movie
import com.sweet.cloves.simplemovie.databinding.ActivityMainBinding
import com.sweet.cloves.simplemovie.network.ResourceState
import com.sweet.cloves.simplemovie.ui.base.BaseActivity
import com.sweet.cloves.simplemovie.ui.screen.main.adapter.GenreAdapter
import com.sweet.cloves.simplemovie.ui.screen.main.adapter.LatestAdapter
import com.sweet.cloves.simplemovie.ui.screen.main.adapter.TrendingSliderPagerAdapter
import com.sweet.cloves.simplemovie.util.MarginItemDecoration
import com.sweet.cloves.simplemovie.util.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val TAG = this::class.java.name
    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val viewModel by viewModel<MainViewModel>()

    private lateinit var pagerAdapter: TrendingSliderPagerAdapter
    private lateinit var latestMovieAdapter: LatestAdapter
    private lateinit var actionMovieAdapter: GenreAdapter

    private var trendingMovieList: List<Movie> = ArrayList()
    private var latestMovieList: List<Movie> = ArrayList()
    private var actionMovieList: List<Movie> = ArrayList()

    private var isLoading = false
    private var runnable: Runnable? = null
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        pagerAdapter = TrendingSliderPagerAdapter(this)
        binding.vpSlider.adapter = pagerAdapter
        binding.vpSlider.setCurrentItem(0)

        latestMovieAdapter = LatestAdapter(this)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvLatest.layoutManager = linearLayoutManager
        binding.rvLatest.adapter = latestMovieAdapter


        actionMovieAdapter = GenreAdapter(this)
        val spaceCount = 2
        val layoutManager = GridLayoutManager(this, spaceCount)
        binding.rvGenre.layoutManager = layoutManager
        binding.rvGenre.addItemDecoration(
            MarginItemDecoration(resources.getDimensionPixelSize(R.dimen.margin_10), spaceCount)
        )
        binding.rvGenre.adapter = actionMovieAdapter
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        binding.toolbar.inflateMenu(R.menu.menu_main)
        with(binding.toolbar.menu) {
            findItem(R.id.action_search).actionView.let {

            }
        }
        return super.onCreateOptionsMenu(menu)
    }

    override suspend fun onObserveAction() {
        super.onObserveAction()
        viewModel.getTrendingMovieEveryWeek(BuildConfig.API_KEY).observe(this) {
                when(it.state) {
                    ResourceState.LOADING -> {
                        Log.d(TAG, "onLoading")
                    }
                    ResourceState.SUCCESS -> {
                        Log.d(TAG, "onSuccess")
                        it.data?.results?.let { movie ->
                            if(trendingMovieList.size == 0) {
                                trendingMovieList = movie
                                val shortFiveItem = trendingMovieList.take(5)
                                pagerAdapter.setData(shortFiveItem)
                                addBottomDots(binding.layoutDots, pagerAdapter.count, 0)
                                startAutoSlider(pagerAdapter.count)
                            }
                            binding.vpSlider.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

                                override fun onPageScrollStateChanged(state: Int) {
                                }

                                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

                                }
                                override fun onPageSelected(position: Int) {
                                    addBottomDots(binding.layoutDots, pagerAdapter.count, position)
                                }
                            })

//                            updateUI(page, movie)
                        }
                    }
                    ResourceState.ERROR -> {
                        Log.d(TAG, "onError")
                    }
                }
            }
        viewModel.getLatestMovieReleased(BuildConfig.API_KEY, "en-US")
            .observe(this) {
                when (it.state) {
                    ResourceState.LOADING -> {
                        Log.d(TAG, "onLoading")
                    }
                    ResourceState.SUCCESS -> {
                        Log.d(TAG, "onSuccess")
                        it.data?.results?.let { movie ->
                            if (latestMovieList.size == 0){
                                latestMovieList = movie
                                latestMovieAdapter.setData(latestMovieList)
                            }
//                            updateUI(page, movie)
                        }
                    }
                    ResourceState.ERROR -> {
                        Log.d(TAG, "onError")
                    }
                }
            }
        viewModel.getMovieAction(BuildConfig.API_KEY, "28", "1")
            .observe(this) {
                when(it.state) {
                    ResourceState.LOADING -> {
                        Log.d(TAG, "onLoading")
                        isLoading = it.showLoading ?: false


//                        if (isLoading) {
//                            if (adapter.getData().isNotEmpty()) {
//                                adapter.addLoadingView()
//                                binding.recyclerArticle.smoothScrollToPosition(articleAdapter.itemCount)
//                            } else {
//                                binding.progressCircular.visible()
//                            }
//                        } else {
//                            articleAdapter.removeLoadingView()
//                            binding.swipeRefreshLayout.stopRefreshing()
//                            binding.progressCircular.gone()
//                        }
                    }
                    ResourceState.SUCCESS -> {
                        Log.d(TAG, "onSuccess")
                        it.data?.results?.let { movie ->
                            if (actionMovieList.size == 0){
                                actionMovieList = movie
                                actionMovieAdapter.setData(actionMovieList)
                            }
//                            updateUI(page, movie)
                        }
                    }
                    ResourceState.ERROR -> {
                        Log.d(TAG, "onError")
                    }

                }
            }
    }

    @SuppressLint("ResourceType")
    private fun addBottomDots(layout_dots: LinearLayout, size: Int, current: Int) {
        val dots: Array<ImageView?> = arrayOfNulls<ImageView>(size)
        layout_dots.removeAllViews()
        for (i in dots.indices) {
            dots[i] = ImageView(this)
            val width_height = 15
            val params: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(LinearLayout.LayoutParams(width_height, width_height))
            params.setMargins(10, 0, 10, 0)
            dots[i]?.layoutParams = params
            dots[i]?.setImageResource(R.drawable.shape_circle_outline)
            dots[i]?.setColorFilter(
                ContextCompat.getColor(this, R.color.purple_700),
                PorterDuff.Mode.SRC_ATOP
            )
            layout_dots.addView(dots[i])
        }
        if (dots.size > 0) {
            dots[current]?.setImageResource(R.drawable.shape_circle)
            dots[current]?.setColorFilter(
                ContextCompat.getColor(this, R.color.purple_700),
                PorterDuff.Mode.SRC_ATOP
            )
        }
    }

    private fun startAutoSlider(count: Int) {
        runnable = Runnable {
            var pos: Int = binding.vpSlider.getCurrentItem()
            pos = pos + 1
            if (pos >= count) pos = 0
            binding.vpSlider.setCurrentItem(pos)
            runnable?.let { handler.postDelayed(it, 3000) }
        }
        handler.postDelayed(runnable!!, 3000)
    }
}
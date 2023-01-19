package com.sweet.cloves.simplemovie.ui.screen.detail

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.sweet.cloves.simplemovie.BuildConfig
import com.sweet.cloves.simplemovie.data.model.MovieDetails
import com.sweet.cloves.simplemovie.data.model.response.TrailerResponse
import com.sweet.cloves.simplemovie.databinding.DialogMovieDetailBinding
import com.sweet.cloves.simplemovie.network.ResourceState
import org.koin.androidx.viewmodel.ext.android.viewModel

class DialogDetail() : DialogFragment(){

    private var movieID : Int? = null

    private lateinit var binding: DialogMovieDetailBinding
    private val viewModel by viewModel<DetailViewModel>()

    companion object {

        const val TAG = "SimpleDialog"

        private const val KEY_MOVIE_ID = "MOVIE_ID"

        fun newInstance(bundle: Bundle): DialogDetail {
            val args = Bundle()
            args.putInt(KEY_MOVIE_ID, bundle.getInt(KEY_MOVIE_ID))
            val fragment = DialogDetail()
            fragment.arguments = args
            return fragment
        }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = DialogMovieDetailBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//
//        binding.btClose.setOnClickListener {
//            dismiss()
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieID = arguments?.getInt(KEY_MOVIE_ID)

        subscribeUI()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog?.requestWindowFeature((Window.FEATURE_NO_TITLE))
        dialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.setCancelable(false)
        binding = DialogMovieDetailBinding.inflate(layoutInflater)
        val view = binding.root

        binding.btClose.setOnClickListener {
            dismiss()
        }

        return view
    }

    private fun subscribeUI(){
        viewModel.getMovieDetailByID(movieID.toString(), BuildConfig.API_KEY).observe(this) {
            when(it.state) {
                ResourceState.LOADING -> {
                    Log.d(TAG, "onLoading")
                }
                ResourceState.SUCCESS -> {
                    Log.d(TAG, "onSuccess")
                    it.data?.let { result ->
                        updatePrimaryInformationUI(result)
                    }
                }
                ResourceState.ERROR -> {
                    Log.d(TAG, "onError")
                }
            }
        }
        viewModel.getMovieTrailerByID(movieID.toString(), BuildConfig.API_KEY).observe(this) {
            when(it.state) {
                ResourceState.LOADING -> {
                    Log.d(TAG, "onLoading")
                }
                ResourceState.SUCCESS -> {
                    Log.d(TAG, "onSuccess")
                    it.data?.let { result->
                        updateMovieTrailer(result)
                    }
                }
                ResourceState.ERROR -> {
                    Log.d(TAG, "onError")
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updatePrimaryInformationUI(movieDetails: MovieDetails) {
        binding.tvMovieTitle.text = movieDetails.title
        val rating =  5 * ((movieDetails.voteAverage?.div(10f)!!))
        binding.rbMovie.rating  = rating.toFloat()
        binding.tvVoteAverage.text = "${movieDetails.voteCount} votes"
        binding.tvMovieDesc.text = movieDetails.overview
    }

    private fun updateMovieTrailer(trailerResponse: TrailerResponse) {
        var key = ""
        for (j in trailerResponse.results){
            key = j.key.toString()
            println("Key : $key")
        }
        lifecycle.addObserver(binding.youtubePlayerView)
        binding.youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(key, 0f)
            }
        })
    }

}
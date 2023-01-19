package com.sweet.cloves.simplemovie.ui.screen.main.adapter

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sweet.cloves.simplemovie.BuildConfig
import com.sweet.cloves.simplemovie.R
import com.sweet.cloves.simplemovie.data.model.Movie
import com.sweet.cloves.simplemovie.databinding.DialogLoadingBinding
import com.sweet.cloves.simplemovie.databinding.GridItemGenreBinding
import com.sweet.cloves.simplemovie.ui.screen.detail.DialogDetail
import com.sweet.cloves.simplemovie.util.viewBinding

class GenreAdapter(private val context: Activity): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var data = ArrayList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ITEM) {
            MovieViewHolder(parent.viewBinding(GridItemGenreBinding::inflate))
        } else {
            LoadingViewHolder(parent.viewBinding(DialogLoadingBinding::inflate))
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == VIEW_TYPE_ITEM) {
            val item = data[position]
            if (item != null) {
                (holder as MovieViewHolder).bind(item)
            }
        }
    }

    inner class LoadingViewHolder(binding: DialogLoadingBinding): RecyclerView.ViewHolder(binding.root)

    inner class MovieViewHolder(private val binding: GridItemGenreBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Movie) = with(binding) {
            Glide.with(itemView.context)
                .load(BuildConfig.IMAGE_URL + item.backdropPath)
//                .apply(requestOptionsCircular(itemView.context))
                .error(R.mipmap.no_image)
                .into(ivMoviePoster)
            tvMovieTitle.text = item.title
//            textArticleDate.text = DateUtils.convertTime(item.publishedAt)
//            textArticleDesc.text = HtmlCompat.fromHtml(item.content ?: "", HtmlCompat.FROM_HTML_MODE_COMPACT)
            itemView.setOnClickListener {
               Log.d("TAG", "${item.title} clicked!")
//                val dialog = DialogDetail(context)
//                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//                dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//                dialog.setCancelable(false)
//                dialog.show()
                val args = Bundle()
                item.id?.let { it1 -> args.putInt("MOVIE_ID", it1) }
                val manager: FragmentManager = (context as AppCompatActivity).getSupportFragmentManager()
                DialogDetail.newInstance(args).show(manager, DialogDetail.TAG)
            }
        }
    }

//    fun addLoadingView() {
//        // Add loading to the last index
//        Handler(Looper.getMainLooper()).post {
//            val tempArr = data.toMutableList()
//            tempArr.add(null)
//            data = tempArr
//            notifyItemInserted(data.lastIndex)
//        }
//    }

//    fun removeLoadingView() {
//        // Remove last item if the last item is loading view
//        val removedIndex = data.indexOf(null)
//        if (removedIndex == -1) return
//        if (data.isNotEmpty() && getItemViewType(removedIndex) == VIEW_TYPE_LOADING) {
//            val tempArr = data.toMutableList()
//            tempArr.removeAt(removedIndex)
//            data = tempArr
//            notifyItemRemoved(removedIndex)
//        }
//    }

    fun setData(data: List<Movie>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    fun getData(): List<Movie> = data.filterNotNull()

    fun clearData() {
        data.clear()
        notifyDataSetChanged()
    }

    companion object {
        const val VIEW_TYPE_LOADING = 1
        const val VIEW_TYPE_ITEM = 0
    }
}
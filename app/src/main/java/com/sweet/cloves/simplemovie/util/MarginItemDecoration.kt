package com.sweet.cloves.simplemovie.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(
    private val spaceSize: Int,
    private val spanCount: Int,
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        val position : Int = parent.getChildAdapterPosition(view)

        if (position >= 0) {
            val column : Int =  position % spanCount
            outRect.left = spaceSize - column * spaceSize / spanCount
            outRect.right = (column + 1) * spaceSize / spanCount

            if (position < spanCount) {
                outRect.top = spaceSize
            }
            outRect.bottom = spaceSize
        } else {
            outRect.left = 0;
            outRect.right = 0;
            outRect.top = 0;
            outRect.bottom = 0;
        }
    }
}
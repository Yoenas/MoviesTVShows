package com.yoenas.movietvshow.presentation.favorite

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

abstract class SwipeToDelete(private var swipeDirection: Int) :
    ItemTouchHelper.Callback() {

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        return makeMovementFlags(
            0, swipeDirection
        )
    }

    init {
        this.swipeDirection = when (swipeDirection) {
            0 -> ItemTouchHelper.LEFT
            1 -> ItemTouchHelper.RIGHT
            else -> ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        }
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return true
    }
}
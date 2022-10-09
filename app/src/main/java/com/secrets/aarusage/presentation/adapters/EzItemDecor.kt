package com.secrets.aarusage.presentation.adapters

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.secrets.aarusage.presentation.holders.ButtonViewHolder
import com.secrets.aarusage.presentation.holders.EditTextViewHolder
import com.secrets.aarusage.presentation.holders.LabelViewHolder

class EzItemDecor: RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val type = parent.layoutManager?.getItemViewType(view)

        when(type) {
            ButtonViewHolder.layout,
            LabelViewHolder.layout -> {
                outRect.top = 30
                outRect.left = 20
                outRect.right = 20
                outRect.bottom = 20
            }
            EditTextViewHolder.layout -> {
                outRect.top = 10
                outRect.left = 20
                outRect.right = 20
                outRect.bottom = 20
            }
        }

    }

}
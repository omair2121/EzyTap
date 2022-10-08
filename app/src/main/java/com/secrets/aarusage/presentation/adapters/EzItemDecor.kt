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
//        super.getItemOffsets(outRect, view, parent, state)
        val type = parent.layoutManager?.getItemViewType(view)

        when(type) {
            EditTextViewHolder.layout,
            ButtonViewHolder.layout,
            LabelViewHolder.layout -> {
                outRect.top = 20
                outRect.left = 16
                outRect.right = 16
                outRect.bottom = 20
            }
        }

    }

}
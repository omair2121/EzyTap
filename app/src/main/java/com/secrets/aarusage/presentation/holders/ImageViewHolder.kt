package com.secrets.aarusage.presentation.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.secrets.aarusage.R
import com.secrets.aarusage.databinding.ItemImageBinding
import com.secrets.aarusage.databinding.ItemLabelBinding
import com.secrets.network.models.UiData

class ImageViewHolder(private val binding: ItemImageBinding): RecyclerView.ViewHolder(binding.root) {

    companion object {
        const val layout = R.layout.item_image
        fun create(inflater: LayoutInflater, viewGroup: ViewGroup): ImageViewHolder {
            val binding = ItemImageBinding.inflate(inflater, viewGroup, false)
            return ImageViewHolder(binding)
        }
    }

    fun bind(item: UiData) {
    }
}
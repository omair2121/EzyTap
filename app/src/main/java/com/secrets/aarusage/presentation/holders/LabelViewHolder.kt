package com.secrets.aarusage.presentation.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.secrets.aarusage.R
import com.secrets.aarusage.databinding.ItemLabelBinding
import com.secrets.network.models.UiData

class LabelViewHolder(private val binding: ItemLabelBinding): RecyclerView.ViewHolder(binding.root) {

    companion object {
        const val layout = R.layout.item_label
        fun create(inflater: LayoutInflater, viewGroup: ViewGroup): LabelViewHolder {
            val binding = ItemLabelBinding.inflate(inflater, viewGroup, false)
            return LabelViewHolder(binding)
        }
    }

    fun bind(item: UiData) {
        binding.labelTv.text = item.value ?: item.hint ?: item.uiType
    }
}
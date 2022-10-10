package com.secrets.aarusage.presentation.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.secrets.aarusage.R
import com.secrets.aarusage.databinding.ItemButtonBinding
import com.secrets.aarusage.databinding.ItemLabelBinding
import com.secrets.network.models.UiData
import java.util.zip.Inflater

class ButtonViewHolder(private val binding: ItemButtonBinding, private val btnListener: () -> Unit): RecyclerView.ViewHolder(binding.root) {

    companion object {
        const val layout = R.layout.item_button
        fun create(inflater: LayoutInflater, viewGroup: ViewGroup, btnListener: () -> Unit): ButtonViewHolder {
            val binding = ItemButtonBinding.inflate(inflater, viewGroup, false)
            return ButtonViewHolder(binding, btnListener)
        }
    }

    fun bind(item: UiData) {
        binding.button.text = item.value ?: item.hint ?: item.uiType
        binding.button.setOnClickListener {
                btnListener.invoke()
        }
    }
}
package com.secrets.aarusage.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.secrets.network.models.UiData

class EzDiffUtil: DiffUtil.ItemCallback<UiData>() {
    override fun areItemsTheSame(oldItem: UiData, newItem: UiData): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItem: UiData, newItem: UiData): Boolean {
        return false
    }
}
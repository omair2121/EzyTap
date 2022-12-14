package com.secrets.aarusage.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.secrets.aarusage.presentation.ValueChangeListener
import com.secrets.aarusage.presentation.holders.ButtonViewHolder
import com.secrets.aarusage.presentation.holders.EditTextViewHolder
import com.secrets.aarusage.presentation.holders.LabelViewHolder
import com.secrets.aarusage.util.Constants
import com.secrets.network.models.UiData


/**
 * this adapter is main adapter having 2 listeners, one is for edit text, and other for button click.
 * @param editTextListener is implemented in viewmodel, so direct communication with livedata is happening
 */
class EzAdapter(private val editTextListener: ValueChangeListener, private val btnListener: () -> Unit): ListAdapter<UiData, RecyclerView.ViewHolder>(EzDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder: RecyclerView.ViewHolder
        val inflater = LayoutInflater.from(parent.context)
        viewHolder = when(viewType) {
            LabelViewHolder.layout -> LabelViewHolder.create(inflater, parent)
            EditTextViewHolder.layout -> EditTextViewHolder.create(inflater, parent, editTextListener)
            ButtonViewHolder.layout -> ButtonViewHolder.create(inflater, parent, btnListener)
            else -> LabelViewHolder.create(inflater, parent)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when(holder) {
            is LabelViewHolder -> holder.bind(item)
            is EditTextViewHolder -> holder.bind(item)
            is ButtonViewHolder -> holder.bind(item)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
       return when(item.uiType.lowercase()) {
            Constants.LABEL -> LabelViewHolder.layout
            Constants.EDITTEXT -> EditTextViewHolder.layout
            Constants.BUTTON -> ButtonViewHolder.layout
           else -> super.getItemViewType(position)
        }
    }
}
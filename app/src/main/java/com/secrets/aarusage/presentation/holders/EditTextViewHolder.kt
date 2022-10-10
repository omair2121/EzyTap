package com.secrets.aarusage.presentation.holders

import android.text.Editable
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.text.InputType
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.secrets.aarusage.R
import com.secrets.aarusage.databinding.ItemEdittextBinding
import com.secrets.aarusage.presentation.ValueChangeListener
import com.secrets.network.models.UiData

class EditTextViewHolder(
    private val binding: ItemEdittextBinding,
    private val editTextListener: ValueChangeListener
): RecyclerView.ViewHolder(binding.root) {

    companion object {
        const val layout = R.layout.item_edittext
        fun create(
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            editTextListener: ValueChangeListener
        ): EditTextViewHolder {
            val binding = ItemEdittextBinding.inflate(inflater, viewGroup, false)
            return EditTextViewHolder(binding, editTextListener)
        }
    }

    fun bind(item: UiData) {
        binding.edittext.setText(item.value)
        binding.edittext.setHint(item.hint ?: item.value)
        binding.edittext.inputType =
            if(item.key?.contains("phone", true) == true)  {
                binding.edittext.setFilters(arrayOf<InputFilter>(LengthFilter(10)))
                InputType.TYPE_CLASS_PHONE
            } else  InputType.TYPE_CLASS_TEXT

        binding.edittext.doAfterTextChanged {
            editTextListener.onValueChange(adapterPosition, it.toString())
        }
    }
}
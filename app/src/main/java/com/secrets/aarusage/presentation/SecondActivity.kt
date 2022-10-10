package com.secrets.aarusage.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.secrets.aarusage.R
import com.secrets.aarusage.databinding.ActivitySecondBinding
import com.secrets.aarusage.presentation.adapters.EzAdapter
import com.secrets.aarusage.presentation.adapters.EzItemDecor
import com.secrets.network.models.UIResponse
import com.secrets.network.models.UiData
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


/**
 * It wasnt clear what we have to do in activity2, as per my understading i passed the value from activity1 and used same adapter to display the updated value
 */

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {
    companion object {
        const val UI_MODEL = "ui_model"
        fun start(ctx: Context, uiResponse: UIResponse) {
            val intent = Intent(ctx, SecondActivity::class.java)
            intent.putExtra(UI_MODEL, uiResponse)
            ctx.startActivity(intent)
        }
    }

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        initBundle()
    }

    private fun initBundle() {
        val data = intent?.getParcelableExtra<UIResponse>(UI_MODEL)
        submitData(data)
    }


    private fun submitData(data: UIResponse?) {
        adapter.submitList(data?.uidata)
    }

    @Inject
    lateinit var viewModel: EzViewModel
    private lateinit var adapter: EzAdapter
    private fun initRecyclerView() {
        adapter = EzAdapter(viewModel) { onBackPressed() }
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter
        if (binding.recycler.itemDecorationCount == 0)
            binding.recycler.addItemDecoration(EzItemDecor())
    }
}
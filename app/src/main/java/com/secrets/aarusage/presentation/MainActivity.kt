package com.secrets.aarusage.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.secrets.aarusage.R
import com.secrets.aarusage.data.ResultResource
import com.secrets.aarusage.databinding.ActivityMainBinding
import com.secrets.aarusage.presentation.adapters.EzAdapter
import com.secrets.aarusage.presentation.adapters.EzItemDecor
import com.secrets.network.models.UIResponse
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import retrofit2.HttpException

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initRecyclerView()
        fetchData()
        observers()
    }

    private fun observers() {
        viewModel.uiResponse.observe(this) {
            onGetUIResponse(it)
        }
    }

    private fun onGetUIResponse(result: ResultResource<UIResponse>?) {
        if (result == null) return
        binding.progress.isVisible = result is ResultResource.Loading
        when(result) {
            is ResultResource.Success -> submitData(result.data)
            is ResultResource.Loading -> {}
            is ResultResource.Error -> {
                val exception = result.exception
                val errorText = if (exception is HttpException) {
                    "Internet connection error"
                } else "Something went wrong"

                Toast.makeText(this, errorText, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun submitData(data: UIResponse) {
        adapter.submitList(data.uidata)
    }

    @Inject
    lateinit var viewModel: EzViewModel
    private fun fetchData() {
        viewModel.fetchCustomUI()
    }

    private lateinit var adapter: EzAdapter
    private fun initRecyclerView() {
        adapter = EzAdapter()
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter
        if (binding.recycler.itemDecorationCount == 0)
            binding.recycler.addItemDecoration(EzItemDecor())
    }
}
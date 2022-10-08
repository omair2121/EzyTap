package com.secrets.aarusage.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.secrets.aarusage.data.ResultResource
import com.secrets.aarusage.data.repo.UIRepository
import com.secrets.network.models.UIResponse
import javax.inject.Inject
import kotlinx.coroutines.launch

class EzViewModel @Inject constructor(private val repo: UIRepository) : ViewModel() {

    private val _uiResponse = MutableLiveData<ResultResource<UIResponse>>()
    val uiResponse: LiveData<ResultResource<UIResponse>>
        get() = _uiResponse

    fun fetchCustomUI() {
        viewModelScope.launch {
            _uiResponse.value = ResultResource.Loading()
            _uiResponse.value = try {
                val response = repo.fetchUi()
                ResultResource.Success(response)
            } catch (e: Exception) {
                ResultResource.Error(e)
            }
        }
    }

}
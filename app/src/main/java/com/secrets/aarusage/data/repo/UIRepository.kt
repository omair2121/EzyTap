package com.secrets.aarusage.data.repo

import com.secrets.network.services.EzService
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UIRepository @Inject constructor(private val ezService: EzService) {

    suspend fun fetchUi() = withContext(Dispatchers.IO) {
        return@withContext ezService.fetchCustomUI()
    }

}
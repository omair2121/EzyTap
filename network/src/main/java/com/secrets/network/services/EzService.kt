package com.secrets.network.services

import com.secrets.network.models.UIResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface EzService {
    @GET("mobileapps/android_assignment.json")
   suspend fun fetchCustomUI(): UIResponse

    @GET("")
    suspend fun fetchImage()
}
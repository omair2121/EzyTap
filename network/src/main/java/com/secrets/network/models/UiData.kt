package com.secrets.network.models

import com.google.gson.annotations.SerializedName

data class UiData(
    @SerializedName("uitype")
    val uiType: String,
    val key: String?,
    val value: String?,
    val hint: String?
)
package com.secrets.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UiData(
    @SerializedName("uitype")
    val uiType: String,
    val key: String?,
    var value: String?,
    val hint: String?
): Parcelable
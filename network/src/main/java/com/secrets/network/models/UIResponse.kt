package com.secrets.network.models

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class UIResponse(
    val uidata: List<UiData>?,
    @SerializedName("logo-url")
    val logoUrl: String?,
    @SerializedName("heading-text")
    val headingText: String?
): Parcelable
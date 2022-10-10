package com.secrets.aarusage.util

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * using glide for image rendering
 */

fun ImageView.load(imgUrl: String?) {
    if (imgUrl.isNullOrBlank()) return
    Glide.with(this.context).load(imgUrl).into(this)
}

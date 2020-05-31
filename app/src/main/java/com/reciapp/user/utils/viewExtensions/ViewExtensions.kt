package com.reciapp.user.utils.viewExtensions

import android.view.View

/**
 * Created by Jorge Henao on 30/05/20.
 */
fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

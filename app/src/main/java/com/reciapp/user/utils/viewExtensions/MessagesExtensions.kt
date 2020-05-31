package com.reciapp.user.utils.viewExtensions

import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * Created by Jorge Henao on 30/05/20.
 */
fun Fragment.showMessage(message: String){
    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
}

package com.reciapp.user.presentation.views.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.reciapp.user.R
import kotlinx.android.synthetic.main.activity_pickup.*

class PickupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pickup)
        initView()
        initListeners()
    }

    private fun initListeners() {
        btnPickupEnd.setOnClickListener {
            Toast.makeText(this, getString(R.string.general_thanks_for_your_request), Toast.LENGTH_LONG).show()
            onBackPressed()
        }
    }

    private fun initView() {
        intent?.extras?.let{
            txvPickerDate.text = it.getString(PICKER_DATE)
            txvPickerHour.text = it.getString(PICKER_HOUR)
        }
    }

    companion object{
        const val PICKER_DATE = "PICKER_DATE"
        const val PICKER_HOUR = "PICKER_HOUR"
    }
}

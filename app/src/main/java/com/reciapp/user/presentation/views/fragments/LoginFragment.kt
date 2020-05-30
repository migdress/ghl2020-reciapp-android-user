package com.reciapp.user.presentation.views.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.reciapp.user.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(
            charSequence: CharSequence,
            i: Int,
            i2: Int,
            i3: Int
        ) {
        }

        override fun onTextChanged(
            charSequence: CharSequence,
            i: Int,
            i2: Int,
            i3: Int
        ) {
        }

        override fun afterTextChanged(editable: Editable) {
            // check Fields For Empty Values
            checkFieldsForEmptyValues()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        tieUserName.addTextChangedListener(textWatcher)
        tieUserPassword.addTextChangedListener(textWatcher)
    }

    fun checkFieldsForEmptyValues() {
        val user: String = tieUserName.text.toString()
        val password: String = tieUserPassword.text.toString()
        btnLogin.isEnabled = !(user.isEmpty() || password.isEmpty())
    }
}

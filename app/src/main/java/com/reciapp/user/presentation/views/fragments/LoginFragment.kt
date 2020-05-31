package com.reciapp.user.presentation.views.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.reciapp.user.R
import com.reciapp.user.presentation.states.LoginState
import com.reciapp.user.presentation.viewModels.LoginViewModel
import com.reciapp.user.utils.viewExtensions.hide
import com.reciapp.user.utils.viewExtensions.hideKeyboardFrom
import com.reciapp.user.utils.viewExtensions.showMessage
import com.reciapp.user.utils.viewExtensions.visible
import kotlinx.android.synthetic.main.content_login.*
import kotlinx.android.synthetic.main.content_waiting.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by viewModel()

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
        initObservers()
    }

    private fun initObservers() {
        loginViewModel.getLoginLiveData.observe(viewLifecycleOwner, Observer {
            renderLoginState(it)
        })
    }

    private fun initListeners() {
        tieUserName.addTextChangedListener(textWatcher)
        tieUserPassword.addTextChangedListener(textWatcher)

        btnLogin.setOnClickListener {
            hideKeyboardFrom()

            loginViewModel.login(tieUserName.text.toString(), tieUserPassword.text.toString())
        }
    }

    /**
     * Enable or disable the Login button
     */
    fun checkFieldsForEmptyValues() {
        val user: String = tieUserName.text.toString()
        val password: String = tieUserPassword.text.toString()
        btnLogin.isEnabled = !(user.isEmpty() || password.isEmpty())
    }

    private fun renderLoginState(loginState: LoginState) {
        when (loginState) {
            is LoginState.Loading -> {
                cnlBodyContent.hide()
                cnlLoadingContent.visible()
            }
            is LoginState.Success -> {
                showMessage("Login exitoso")
            }
            is LoginState.Failure -> {
                cnlLoadingContent.hide()
                cnlBodyContent.visible()
                showMessage(getString(R.string.error_login_failure))
            }
        }
    }
}

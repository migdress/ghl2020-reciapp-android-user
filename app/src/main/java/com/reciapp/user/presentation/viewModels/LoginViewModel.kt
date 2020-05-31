package com.reciapp.user.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.reciapp.user.domain.useCases.LoginUC
import com.reciapp.user.presentation.states.LoginState

/**
 * Created by Jorge Henao on 30/05/20.
 */
class LoginViewModel(
    private val loginUC: LoginUC,
    private val loginLiveData: MutableLiveData<LoginState>
) : BaseViewModel() {

    val getloginLiveData: LiveData<LoginState>
        get() = loginLiveData
}

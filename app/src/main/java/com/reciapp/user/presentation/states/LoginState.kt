package com.reciapp.user.presentation.states

/**
 * Created by Jorge Henao on 30/05/20.
 */
sealed class LoginState {
    object Loading : LoginState()
    object Success : LoginState()
    object ErrorReturnMessage : LoginState()
}

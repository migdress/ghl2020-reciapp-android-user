package com.reciapp.user.presentation.states

/**
 * Created by Jorge Henao on 31/05/20.
 */
sealed class ShiftState {
    object Loading : ShiftState()
    object Success : ShiftState()
    object Failure : ShiftState()
}

package com.reciapp.user.presentation.states

import com.reciapp.user.data.models.openShifts.OpenShiftsResponse

/**
 * Created by Jorge Henao on 31/05/20.
 */
sealed class OpenShiftState {
    class Success(val openShiftsResponse: OpenShiftsResponse) : OpenShiftState()
    object Failure : OpenShiftState()
}

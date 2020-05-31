package com.reciapp.user.domain.useCases

import com.reciapp.user.domain.repositories.OpenShiftRemoteRepository

/**
 * Created by Jorge Henao on 31/05/20.
 */
class OpenShiftUC(
    private val openShiftRemoteRepository: OpenShiftRemoteRepository
) {

    fun getOpenShifts() = openShiftRemoteRepository.getOpenShifts()
}

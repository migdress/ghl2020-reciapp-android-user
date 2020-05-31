package com.reciapp.user.domain.useCases

import com.reciapp.user.domain.repositories.OpenShiftRemoteRepository
import com.reciapp.user.domain.repositories.ShiftRepository

/**
 * Created by Jorge Henao on 31/05/20.
 */
class OpenShiftUC(
    private val openShiftRemoteRepository: OpenShiftRemoteRepository,
    private val shiftRepository: ShiftRepository
) {

    fun getOpenShifts() = openShiftRemoteRepository.getOpenShifts()
        .map { openShiftResponse ->
            shiftRepository.saveShiftInformation(openShiftResponse.shifts[0].id)
        }
}

package com.reciapp.user.domain.useCases

import com.reciapp.user.data.models.openShifts.OpenShiftsResponse
import com.reciapp.user.domain.repositories.OpenShiftRemoteRepository
import com.reciapp.user.domain.repositories.ShiftRepository
import io.reactivex.Single

/**
 * Created by Jorge Henao on 31/05/20.
 */
class OpenShiftUC(
    private val openShiftRemoteRepository: OpenShiftRemoteRepository,
    private val shiftRepository: ShiftRepository
) {

    fun getOpenShifts(): Single<OpenShiftsResponse> {
        return openShiftRemoteRepository.getOpenShifts()
            .flatMap { openShiftResponse ->
                shiftRepository.saveShiftInformation(openShiftResponse.shifts[0].id)

                Single.just(openShiftResponse)
            }
    }
}

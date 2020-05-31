package com.reciapp.user.domain.repositories

import com.reciapp.user.data.models.openShifts.OpenShiftsResponse
import io.reactivex.Single

/**
 * Created by Jorge Henao on 31/05/20.
 */
interface OpenShiftRemoteRepository {

    fun getOpenShifts(): Single<OpenShiftsResponse>
}

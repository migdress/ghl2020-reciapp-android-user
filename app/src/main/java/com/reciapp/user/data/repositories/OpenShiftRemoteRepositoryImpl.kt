package com.reciapp.user.data.repositories

import com.reciapp.user.data.networkeEndPoints.OpenShiftsApi
import com.reciapp.user.domain.repositories.OpenShiftRemoteRepository

/**
 * Created by Jorge Henao on 31/05/20.
 */
class OpenShiftRemoteRepositoryImpl(
    private val openShiftsApi: OpenShiftsApi
) : OpenShiftRemoteRepository {

    override fun getOpenShifts() = openShiftsApi.getOpenShifts()
}

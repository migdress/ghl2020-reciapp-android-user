package com.reciapp.user.data.repositories

import com.reciapp.user.data.models.shift.ShiftRequest
import com.reciapp.user.data.networkeEndPoints.ShiftApi
import com.reciapp.user.domain.repositories.ShiftRemoteRepository

/**
 * Created by Jorge Henao on 31/05/20.
 */
class ShiftRemoteRepositoryImpl(
    private val shiftApi: ShiftApi
) : ShiftRemoteRepository {

    override fun requestPickup(shiftRequest: ShiftRequest) = shiftApi.requestPickup(shiftRequest)
}

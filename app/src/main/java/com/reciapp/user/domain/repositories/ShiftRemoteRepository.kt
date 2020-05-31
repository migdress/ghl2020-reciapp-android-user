package com.reciapp.user.domain.repositories

import com.reciapp.user.data.models.shift.ShiftRequest
import io.reactivex.Completable

/**
 * Created by Jorge Henao on 31/05/20.
 */
interface ShiftRemoteRepository {

    fun requestPickup(shiftRequest: ShiftRequest): Completable
}

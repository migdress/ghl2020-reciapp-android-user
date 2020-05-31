package com.reciapp.user.data.networkeEndPoints

import com.reciapp.user.data.models.shift.ShiftRequest
import io.reactivex.Completable
import retrofit2.http.Body
import retrofit2.http.PUT

/**
 * Created by Jorge Henao on 31/05/20.
 */
interface ShiftApi {

    @PUT("v1")
    fun requestPickup(@Body shiftRequest: ShiftRequest): Completable
}

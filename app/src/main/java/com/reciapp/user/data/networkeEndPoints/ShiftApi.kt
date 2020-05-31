package com.reciapp.user.data.networkeEndPoints

import com.reciapp.user.data.models.shift.ShiftRequest
import io.reactivex.Completable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Jorge Henao on 31/05/20.
 */
interface ShiftApi {

    @POST("v1/shifts")
    fun requestPickup(@Body shiftRequest: ShiftRequest): Completable
}

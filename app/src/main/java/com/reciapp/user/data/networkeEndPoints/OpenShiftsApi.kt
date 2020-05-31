package com.reciapp.user.data.networkeEndPoints

import com.reciapp.user.data.models.openShifts.OpenShiftsResponse
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Jorge Henao on 31/05/20.
 */
interface OpenShiftsApi {

    @GET("v1")
    fun getOpenShifts(): Single<OpenShiftsResponse>
}

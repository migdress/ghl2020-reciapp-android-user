package com.reciapp.user.data.networkeEndPoints

import com.reciapp.user.data.models.points.UserPointsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Jorge Henao on 31/05/20.
 */
interface PointsApi {

    @GET("v1/{user_id}")
    fun getUserPoints(@Path("user_id") userId: String): Single<UserPointsResponse>
}

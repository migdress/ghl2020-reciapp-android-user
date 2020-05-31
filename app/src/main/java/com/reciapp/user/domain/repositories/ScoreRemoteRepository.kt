package com.reciapp.user.domain.repositories

import com.reciapp.user.data.models.points.UserPointsResponse
import io.reactivex.Single

/**
 * Created by Jorge Henao on 31/05/20.
 */
interface ScoreRemoteRepository {

    /**
     * Method used to generate the request to get user points
     */
    fun getUserScore(userId: String): Single<UserPointsResponse>
}

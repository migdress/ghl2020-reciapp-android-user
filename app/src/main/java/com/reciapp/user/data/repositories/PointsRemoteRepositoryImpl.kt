package com.reciapp.user.data.repositories

import com.reciapp.user.data.networkeEndPoints.PointsApi
import com.reciapp.user.domain.repositories.PointsRemoteRepository

/**
 * Created by Jorge Henao on 31/05/20.
 */
class PointsRemoteRepositoryImpl(
    private val pointsApi: PointsApi
) : PointsRemoteRepository {

    /**
     * Method used to generate the request to get user points
     */
    override fun getUserPoints(userId: String) = pointsApi.getUserPoints(userId)
}

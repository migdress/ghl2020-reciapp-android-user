package com.reciapp.user.data.repositories

import com.reciapp.user.data.networkeEndPoints.ScoreApi
import com.reciapp.user.domain.repositories.ScoreRemoteRepository

/**
 * Created by Jorge Henao on 31/05/20.
 */
class ScoreRemoteRepositoryImpl(
    private val scoreApi: ScoreApi
) : ScoreRemoteRepository {

    /**
     * Method used to generate the request to get user points
     */
    override fun getUserScore(userId: String) = scoreApi.getUserScore(userId)
}

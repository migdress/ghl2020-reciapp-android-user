package com.reciapp.user.domain.useCases

import com.reciapp.user.domain.repositories.PointsRemoteRepository

/**
 * Created by Jorge Henao on 31/05/20.
 */
class PointsUC(
    private val pointsRemoteRepository: PointsRemoteRepository,
    private val getUserId: () -> String
) {

    fun getUserPoints() = pointsRemoteRepository.getUserPoints(getUserId.invoke())
}

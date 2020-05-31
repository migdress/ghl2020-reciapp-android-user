package com.reciapp.user.domain.useCases

import com.reciapp.user.domain.repositories.ScoreRemoteRepository

/**
 * Created by Jorge Henao on 31/05/20.
 */
class ScoreUC(
    private val scoreRemoteRepository: ScoreRemoteRepository,
    private val getUserId: () -> String
) {

    fun getUserScore() = scoreRemoteRepository.getUserScore(getUserId.invoke())
}

package com.reciapp.user.presentation.states

/**
 * Created by Jorge Henao on 31/05/20.
 */
sealed class PointsState {
    class Success(val points: Int): PointsState()
    object Failure: PointsState()
}

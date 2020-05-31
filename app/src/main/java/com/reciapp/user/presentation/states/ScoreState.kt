package com.reciapp.user.presentation.states

/**
 * Created by Jorge Henao on 31/05/20.
 */
sealed class ScoreState {
    class Success(val points: Int): ScoreState()
    object Failure: ScoreState()
}

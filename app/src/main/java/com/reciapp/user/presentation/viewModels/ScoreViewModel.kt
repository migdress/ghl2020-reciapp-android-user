package com.reciapp.user.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.reciapp.user.domain.useCases.ScoreUC
import com.reciapp.user.presentation.states.ScoreState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Jorge Henao on 31/05/20.
 */
class ScoreViewModel(
    private val scoreUC: ScoreUC,
    private val pointsLiveData: MutableLiveData<ScoreState>
) : BaseViewModel() {

    val getScoreLiveData: LiveData<ScoreState>
        get() = pointsLiveData

    fun getUserScore() {
        addDisposable(
            scoreUC.getUserScore()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    pointsLiveData.value = ScoreState.Success(it.score)
                }, {
                    pointsLiveData.value = ScoreState.Failure
                })
        )
    }
}

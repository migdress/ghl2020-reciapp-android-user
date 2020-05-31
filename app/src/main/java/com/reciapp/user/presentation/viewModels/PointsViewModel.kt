package com.reciapp.user.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.reciapp.user.domain.useCases.PointsUC
import com.reciapp.user.presentation.states.PointsState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Jorge Henao on 31/05/20.
 */
class PointsViewModel(
    private val pointsUC: PointsUC,
    private val pointsLiveData: MutableLiveData<PointsState>
) : BaseViewModel() {

    val getPointsLiveData: LiveData<PointsState>
        get() = pointsLiveData

    fun getUserPoints() {
        addDisposable(
            pointsUC.getUserPoints()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    pointsLiveData.value = PointsState.Success(it.score)
                }, {
                    pointsLiveData.value = PointsState.Failure
                })
        )
    }
}

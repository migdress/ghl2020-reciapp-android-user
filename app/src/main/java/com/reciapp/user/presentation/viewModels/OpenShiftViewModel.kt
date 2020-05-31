package com.reciapp.user.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.reciapp.user.domain.useCases.OpenShiftUC
import com.reciapp.user.presentation.states.OpenShiftState
import com.reciapp.user.utils.applySchedulers

/**
 * Created by Jorge Henao on 31/05/20.
 */
class OpenShiftViewModel(
    private val openShiftUC: OpenShiftUC,
    private val openShiftLiveData: MutableLiveData<OpenShiftState>
) : BaseViewModel() {

    val getOpenShiftLiveData: LiveData<OpenShiftState>
        get() = openShiftLiveData

    fun getOpenShifts() {
        addDisposable(openShiftUC.getOpenShifts()
            .applySchedulers()
            .subscribe({
                openShiftLiveData.value = OpenShiftState.Success(it)
            }, {
                openShiftLiveData.value = OpenShiftState.Failure
            })
        )
    }
}

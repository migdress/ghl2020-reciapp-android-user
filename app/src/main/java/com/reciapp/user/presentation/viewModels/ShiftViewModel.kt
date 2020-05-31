package com.reciapp.user.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.reciapp.user.data.models.recycleType.RecycleType
import com.reciapp.user.domain.useCases.ShiftUC
import com.reciapp.user.presentation.states.ShiftState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Jorge Henao on 31/05/20.
 */
class ShiftViewModel(
    private val shiftUC: ShiftUC,
    private val shiftLiveData: MutableLiveData<ShiftState>
) : BaseViewModel() {

    val getShiftLiveData: LiveData<ShiftState>
        get() = shiftLiveData

    fun requestPickup(listRecycleType: List<RecycleType>) {
        addDisposable(shiftUC.requestPickup(listRecycleType)
            .doOnSubscribe {
                shiftLiveData.postValue(ShiftState.Loading)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                shiftLiveData.value = ShiftState.Success
            }, {
                shiftLiveData.value = ShiftState.Failure
            })
        )
    }
}

package com.reciapp.user.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.reciapp.user.data.models.recycleType.RecycleType
import com.reciapp.user.domain.useCases.RecycleTypeUC

/**
 * Created by Jorge Henao on 31/05/20.
 */
class RecycleTypeViewModel(
    private val recycleTypeUC: RecycleTypeUC,
    private val recycleTypeLiveData: MutableLiveData<List<RecycleType>>
) : BaseViewModel() {

    val getRecycleTypeLiveData: LiveData<List<RecycleType>>
        get() = recycleTypeLiveData

    fun getRecycleTypes() {
        recycleTypeLiveData.value = recycleTypeUC.getRecycleTypes()
    }
}

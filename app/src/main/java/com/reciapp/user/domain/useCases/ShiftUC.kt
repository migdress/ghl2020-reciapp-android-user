package com.reciapp.user.domain.useCases

import com.reciapp.user.data.models.recycleType.RecycleType
import com.reciapp.user.data.models.shift.ShiftRequest
import com.reciapp.user.domain.repositories.ShiftRemoteRepository
import io.reactivex.Completable

/**
 * Created by Jorge Henao on 31/05/20.
 */
class ShiftUC(
    private val shiftRemoteRepository: ShiftRemoteRepository,
    private val getShiftId: () -> String,
    private val getUserId: () -> String,
    private val getLocationId: () -> String
) {

    fun requestPickup(listRecycleType: List<RecycleType>): Completable {
        val materials = listRecycleType.filter { it.isSelected }
            .map {
                it.materialName
            }

        return shiftRemoteRepository.requestPickup(
            ShiftRequest(
                getUserId.invoke(),
                getShiftId.invoke(),
                getLocationId.invoke(),
                materials
            )
        )
    }
}

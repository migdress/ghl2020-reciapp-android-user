package com.reciapp.user.domain.repositories

/**
 * Created by Jorge Henao on 31/05/20.
 */
interface ShiftRepository {

    fun saveShiftInformation(shiftId: String)

    fun getShiftId(): String
}

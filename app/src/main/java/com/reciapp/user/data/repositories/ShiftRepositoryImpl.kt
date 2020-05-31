package com.reciapp.user.data.repositories

import com.reciapp.user.data.preferences.ShiftPreferences
import com.reciapp.user.domain.repositories.ShiftRepository

/**
 * Created by Jorge Henao on 31/05/20.
 */
class ShiftRepositoryImpl(
    private val shiftPreferences: ShiftPreferences
) : ShiftRepository {

    override fun saveShiftInformation(shiftId: String) {
        shiftPreferences.shiftId = shiftId
    }
}

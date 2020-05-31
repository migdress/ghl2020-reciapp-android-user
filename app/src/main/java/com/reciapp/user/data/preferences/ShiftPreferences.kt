package com.reciapp.user.data.preferences

import android.content.SharedPreferences
import com.reciapp.user.utils.preferences.PreferencesHelper.get
import com.reciapp.user.utils.preferences.PreferencesHelper.set

/**
 * Created by Jorge Henao on 31/05/20.
 */
class ShiftPreferences(
    private val preferences: SharedPreferences
) {

    var shiftId: String
        get() = preferences[SHIFT_ID, String()] ?: String()
        set(value) {
            preferences[SHIFT_ID] = value
        }

    fun clear() {
        preferences.edit().clear().apply()
    }

    companion object {
        const val SHIFT_ID = "shift_id"
    }
}

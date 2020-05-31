package com.reciapp.user.data.preferences

import android.annotation.SuppressLint
import android.content.SharedPreferences
import com.reciapp.user.utils.preferences.PreferencesHelper.get
import com.reciapp.user.utils.preferences.PreferencesHelper.set

/**
 * Created by Jorge Henao on 30/05/20.
 */
class UserPreferences(
    private val preferences: SharedPreferences) {

    var id: String
        get() = preferences[USER_ID, String()] ?: String()
        set(value) {
            preferences[USER_ID] = value
        }

    var lastName: String
        get() = preferences[USER_LAST_NAME, String()] ?: String()
        set(value) {
            preferences[USER_LAST_NAME] = value
        }

    var firstName: String
        get() = preferences[USER_FIRST_NAME, String()] ?: String()
        set(value) {
            preferences[USER_FIRST_NAME] = value
        }

    var type: String
        get() = preferences[USER_TYPE, String()] ?: String()
        set(value) {
            preferences[USER_TYPE] = value
        }

    var locationId: String
        get() = preferences[USER_LOCATION_ID, String()] ?: String()
        set(value) {
            preferences[USER_LOCATION_ID] = value
        }

    @SuppressLint("ApplySharedPref")
    fun clear() {
        preferences.edit().clear().commit()
    }

    companion object {
        const val USER_ID = "user_id"
        const val USER_FIRST_NAME = "user_first_name"
        const val USER_LAST_NAME = "user_last_name"
        const val USER_TYPE = "user_type"
        const val USER_LOCATION_ID = "user_location_id"
    }
}

package com.reciapp.user.data.repositories

import com.reciapp.user.data.models.login.LoginResponse
import com.reciapp.user.data.preferences.UserPreferences
import com.reciapp.user.domain.repositories.UserRepository

/**
 * Created by Jorge Henao on 30/05/20.
 */
class UserRepositoryImpl(
    private val userPreferences: UserPreferences
) : UserRepository {

    override fun saveUserInfo(loginResponse: LoginResponse) {
        userPreferences.apply {
            id = loginResponse.id
            firstName = loginResponse.firstName
            lastName = loginResponse.lastName
            type = loginResponse.type
            locationId = loginResponse.locations[0].id
        }
    }

    override fun getUserId() = userPreferences.id
}

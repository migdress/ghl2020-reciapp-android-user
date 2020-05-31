package com.reciapp.user.data.repositories

import com.reciapp.user.data.models.login.LoginResponse
import com.reciapp.user.data.preferences.UserPreferences
import com.reciapp.user.domain.repositories.LoginLocalRepository

/**
 * Created by Jorge Henao on 30/05/20.
 */
class LoginLocalRepositoryImpl(
    private val userPreferences: UserPreferences
) : LoginLocalRepository {

    override fun saveUserInfo(loginResponse: LoginResponse) {
        userPreferences.apply {
            id = loginResponse.id
            firstName = loginResponse.firstName
            lastName = loginResponse.lastName
            type = loginResponse.type
        }
    }
}

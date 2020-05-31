package com.reciapp.user.domain.repositories

import com.reciapp.user.data.models.login.LoginResponse

/**
 * Created by Jorge Henao on 30/05/20.
 */
interface UserRepository {

    fun saveUserInfo(loginResponse: LoginResponse)
}

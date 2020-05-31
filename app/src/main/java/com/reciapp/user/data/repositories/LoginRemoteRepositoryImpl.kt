package com.reciapp.user.data.repositories

import com.reciapp.user.data.models.login.LoginRequest
import com.reciapp.user.data.networkeEndPoints.LoginApi
import com.reciapp.user.domain.repositories.LoginRemoteRepository

/**
 * Created by Jorge Henao on 30/05/20.
 */
class LoginRemoteRepositoryImpl(
    private val loginApi: LoginApi
) : LoginRemoteRepository {

    /**
     * Method used to generate the login request
     */
    override fun login(loginRequest: LoginRequest) = loginApi.login(loginRequest)
}

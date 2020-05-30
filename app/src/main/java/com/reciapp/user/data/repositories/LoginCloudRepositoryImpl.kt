package com.reciapp.user.data.repositories

import com.reciapp.user.data.models.login.LoginRequest
import com.reciapp.user.data.networkeEndPoints.LoginApi
import com.reciapp.user.domain.repositories.LoginCloudRepository

/**
 * Created by Jorge Henao on 30/05/20.
 */
class LoginCloudRepositoryImpl(
    private val loginApi: LoginApi
) : LoginCloudRepository {

    /**
     * Method used to generate the login request
     */
    override fun login(loginRequest: LoginRequest) = loginApi.login(loginRequest)
}

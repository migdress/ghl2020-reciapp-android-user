package com.reciapp.user.domain.repositories

import com.reciapp.user.data.models.login.LoginRequest
import com.reciapp.user.data.models.login.LoginResponse
import io.reactivex.Single

/**
 * Created by Jorge Henao on 30/05/20.
 */
interface LoginCloudRepository {

    /**
     * Method used to generate the login request
     */
    fun login(loginRequest: LoginRequest): Single<LoginResponse>
}

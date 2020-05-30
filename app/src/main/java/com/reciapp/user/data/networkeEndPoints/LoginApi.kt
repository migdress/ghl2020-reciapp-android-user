package com.reciapp.user.data.networkeEndPoints

import com.reciapp.user.data.models.login.LoginRequest
import com.reciapp.user.data.models.login.LoginResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Jorge Henao on 30/05/20.
 */
interface LoginApi {

    @POST("v1")
    fun login(@Body loginRequest: LoginRequest) : Single<LoginResponse>
}

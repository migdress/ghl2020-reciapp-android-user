package com.reciapp.user.data.models.login

import com.squareup.moshi.Json

/**
 * Created by Jorge Henao on 30/05/20.
 */
data class LoginRequest(
    @Json(name = "username")
    val username: String,
    @Json(name = "password")
    val password: String
)

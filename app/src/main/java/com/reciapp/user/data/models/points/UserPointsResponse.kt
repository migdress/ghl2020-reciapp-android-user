package com.reciapp.user.data.models.points

import com.squareup.moshi.Json

/**
 * Created by Jorge Henao on 31/05/20.
 */
data class UserPointsResponse(
    @Json(name = "username")
    val username: String,
    @Json(name = "score")
    val score: Int
)

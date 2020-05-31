package com.reciapp.user.data.models.shift

import com.squareup.moshi.Json

/**
 * Created by Jorge Henao on 31/05/20.
 */
data class ShiftRequest(
    @Json(name = "user_id")
    val userId: String,
    @Json(name = "shift_id")
    val shiftId: String,
    @Json(name = "location_id")
    val locationId: String,
    @Json(name = "materials")
    val materials: List<String>
)

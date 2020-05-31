package com.reciapp.user.data.models.openShifts

import com.squareup.moshi.Json

/**
 * Created by Jorge Henao on 31/05/20.
 */
data class OpenShiftsResponse(
    @Json(name = "shifts")
    val shifts: List<Shift>
) {
    data class Shift(
        @Json(name = "id")
        val id: String,
        @Json(name = "sector")
        val sector: String,
        @Json(name = "shift")
        val shift: String,
        @Json(name = "date")
        val date: String,
        @Json(name = "formatted_date")
        val formattedDate: String
    )
}

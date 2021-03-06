package com.reciapp.user.data.models.login

import com.squareup.moshi.Json

/**
 * Created by Jorge Henao on 30/05/20.
 */
data class LoginResponse(
    @Json(name = "id")
    val id: String,
    @Json(name = "firstname")
    val firstName: String,
    @Json(name = "lastname")
    val lastName: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "locations")
    val locations: List<Location>
) {
    data class Location(
        @Json(name = "id")
        val id: String,
        @Json(name = "name")
        val name: String,
        @Json(name = "country")
        val country: String,
        @Json(name = "city")
        val city: String,
        @Json(name = "address1")
        val firstAddress: String,
        @Json(name = "address2")
        val secondAddress: String,
        @Json(name = "latitude")
        val latitude: Double,
        @Json(name = "longitude")
        val longitude: Double
    )
}

package com.charly.networking.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FeelsLikeData(

    @SerialName("day")
    val day: Double? = null,
    @SerialName("night")
    val night: Double? = null,
    @SerialName("eve")
    val eve: Double? = null,
    @SerialName("morn")
    val morn: Double? = null
)

package com.tracker.londonbusjourney.domain.model

data class BusPosition(
    val vehicleId: String,
    val lat: Double,
    val lon: Double,
    val currentStopName: String,
    val nextStopName: String?,
    val timeToNextStopSeconds: Int
)
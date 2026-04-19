package com.tracker.londonbusjourney.domain.model
data class TrackingRouteStop(
    val naptanId: String,
    val name: String,
    val lat: Double,
    val lon: Double,
    val sequence: Int,
    val isCurrentStop: Boolean = false
)
package com.tracker.londonbusjourney.presentation.screens.tracking

import com.tracker.londonbusjourney.domain.model.TrackingBusPosition
import com.tracker.londonbusjourney.domain.model.TrackingRouteStop

/**
 * UI state for the Tracking screen.
 */
data class TrackingUiState(
    val lineId: String = "",
    val lineName: String = "",
    val vehicleId: String = "",
    val destinationName: String = "",
    val busPosition: TrackingBusPosition? = null,
    val routeStops: List<TrackingRouteStop> = emptyList(),
    val nextStopName: String = "",
    val timeToNextStop: Int = 0,
    val isLoading: Boolean = true,
    val errorMessage: String? = null
)

/**
 * Inferred bus position for UI display.
 */
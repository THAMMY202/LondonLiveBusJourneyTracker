package com.tracker.londonbusjourney.presentation.screens.buslist

import com.tracker.londonbusjourney.domain.model.BusArrival
import com.tracker.londonbusjourney.domain.model.RouteStop

/**
 * UI state for the Bus List screen.
 */
data class BusListUiState(
    val lineId: String = "",
    val lineName: String = "",
    val fromName: String = "",
    val toName: String = "",
    val buses: List<BusArrival> = emptyList(),
    val routeStops: List<RouteStop> = emptyList(),
    val isLoading: Boolean = true,
    val isRefreshing: Boolean = false,
    val errorMessage: String? = null
)
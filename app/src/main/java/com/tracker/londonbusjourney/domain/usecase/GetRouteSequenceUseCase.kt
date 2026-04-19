package com.tracker.londonbusjourney.domain.usecase

import com.tracker.londonbusjourney.domain.model.RouteSequence
import com.tracker.londonbusjourney.domain.repository.BusRepository
import com.tracker.londonbusjourney.domain.common.Result
import javax.inject.Inject

/**
 * Use case for fetching a bus route's stop sequence.
 *
 * Used to get stop coordinates for drawing routes on maps.
 *
 * ## Usage
 * ```kotlin
 * when (val result = getRouteSequenceUseCase("390")) {
 *     is Result.Success -> {
 *         val stops = result.data.stops
 *         drawRouteOnMap(stops.map { LatLng(it.lat, it.lon) })
 *     }
 *     is Result.Error -> showError(result.message)
 * }
 * ```
 */
class GetRouteSequenceUseCase @Inject constructor(
    private val busRepository: BusRepository
) {
    /**
     * Fetches the route sequence for a bus line.
     *
     * @param lineId Bus line ID (e.g., "390", "24")
     * @param direction Route direction ("inbound" or "outbound")
     * @return RouteSequence with ordered stop coordinates
     */
    suspend operator fun invoke(
        lineId: String,
        direction: String = "outbound"
    ): Result<RouteSequence> {
        if (lineId.isBlank()) {
            return Result.Error("Line ID is required")
        }
        return busRepository.getRouteSequence(lineId, direction)
    }
}
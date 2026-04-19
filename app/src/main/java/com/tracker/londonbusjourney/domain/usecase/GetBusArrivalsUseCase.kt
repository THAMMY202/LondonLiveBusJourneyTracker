package com.tracker.londonbusjourney.domain.usecase

import com.tracker.londonbusjourney.domain.model.BusArrival
import com.tracker.londonbusjourney.domain.repository.BusRepository
import javax.inject.Inject

/**
 * Use case for fetching live bus arrival predictions.
 *
 * **Single Responsibility Principle**: Handles only arrival prediction logic.
 *
 */
class GetBusArrivalsUseCase @Inject constructor(
    private val busRepository: BusRepository
) {
    /**
     * Fetches live arrival predictions for a bus line.
     *
     * @param lineId Bus line ID (e.g., "24")
     * @return [Result] with arrivals sorted by time, filtered to next 30 minutes
     */
    suspend operator fun invoke(lineId: String): Result<List<BusArrival>> {
        if (lineId.isBlank()) {
            //return Result.Error("Line ID is required")
            return Result.failure(IllegalArgumentException("Line ID is required"))
        }

        return busRepository.getArrivalsForLine(lineId).map { arrivals ->
            arrivals
                .filter { it.timeToStationMinutes <= MAX_ARRIVAL_MINUTES }
                .distinctBy { it.vehicleId }
                .sortedBy { it.timeToStationSeconds }
        }
    }

    companion object {
        const val MAX_ARRIVAL_MINUTES = 30
        const val POLLING_INTERVAL_MS = 30_000L
    }
}
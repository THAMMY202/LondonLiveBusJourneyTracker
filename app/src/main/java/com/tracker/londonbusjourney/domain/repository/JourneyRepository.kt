package com.tracker.londonbusjourney.domain.repository

import com.tracker.londonbusjourney.domain.common.Result
import com.tracker.londonbusjourney.domain.model.JourneyOption

/**
 * Repository interface for journey planning operations.
 *
 * Following the **Interface Segregation Principle** (SOLID), this interface
 * focuses solely on journey planning concerns.
 */
interface JourneyRepository {

    /**
     * Plans a journey between two locations.
     *
     * @param fromId Origin location ID
     * @param toId Destination location ID
     * @return [Result.Success] with journey options, or [Result.Error] on failure
     */
    suspend fun planJourney(
        fromId: String,
        toId: String
    ): Result<List<JourneyOption>>
}
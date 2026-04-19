package com.tracker.londonbusjourney.domain.repository

import com.tracker.londonbusjourney.domain.common.Result
import com.tracker.londonbusjourney.domain.model.Location

/**
 * Repository interface for location search operations.
 *
 * Following the **Dependency Inversion Principle** (SOLID), the domain layer
 * depends on this abstraction rather than concrete implementations.
 *
 * ## Implementation Notes
 * Implementations should:
 * - Handle network errors gracefully
 * - Return [Result.Error] with user-friendly messages
 * - Filter results to bus-accessible locations
 */
interface LocationRepository {

    /**
     * Searches for locations matching the query.
     *
     * @param query Search term (minimum 2 characters recommended)
     * @return [Result.Success] with matching locations, or [Result.Error] on failure
     */
    suspend fun searchLocations(query: String): Result<List<Location>>
}
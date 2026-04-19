package com.tracker.londonbusjourney.di

import com.tracker.londonbusjourney.data.mapper.TflMapper
import com.tracker.londonbusjourney.data.remote.api.TflApiService
import com.tracker.londonbusjourney.domain.repository.BusRepositoryImpl
import com.tracker.londonbusjourney.domain.repository.JourneyRepositoryImpl
import com.tracker.londonbusjourney.domain.repository.LocationRepositoryImpl
import com.tracker.londonbusjourney.domain.repository.BusRepository
import com.tracker.londonbusjourney.domain.repository.JourneyRepository
import com.tracker.londonbusjourney.domain.repository.LocationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

/**
 * Hilt module for binding repository interfaces to implementations.
 *
 * **Dependency Inversion Principle**: Domain layer depends on abstractions,
 * this module provides the concrete implementations.
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    /**
     * Provides [LocationRepository] implementation.
     */
    @Provides
    @Singleton
    fun provideLocationRepository(
        apiService: TflApiService,
        mapper: TflMapper,
        dispatcher: CoroutineDispatcher
    ): LocationRepository {
        return LocationRepositoryImpl(apiService, mapper, dispatcher)
    }

    /**
     * Provides [JourneyRepository] implementation.
     */
    @Provides
    @Singleton
    fun provideJourneyRepository(
        apiService: TflApiService,
        mapper: TflMapper,
        dispatcher: CoroutineDispatcher
    ): JourneyRepository {
        return JourneyRepositoryImpl(apiService, mapper, dispatcher)
    }

    /**
     * Provides [BusRepository] implementation.
     */
    @Provides
    @Singleton
    fun provideBusRepository(
        apiService: TflApiService,
        mapper: TflMapper,
        dispatcher: CoroutineDispatcher
    ): BusRepository {
        return BusRepositoryImpl(apiService, mapper, dispatcher)
    }
}
package com.tracker.londonbusjourney.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.tracker.londonbusjourney.presentation.screens.buslist.BusListScreen
import com.tracker.londonbusjourney.presentation.screens.journey.JourneyResultsScreen
import com.tracker.londonbusjourney.presentation.screens.landing.LandingScreen
import com.tracker.londonbusjourney.presentation.screens.search.SearchScreen
import com.tracker.londonbusjourney.presentation.screens.tracking.TrackingScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Route.Landing,
        modifier = modifier
    ) {
        composable<Route.Landing> {
            LandingScreen(
                onSearchClick = {
                    navController.navigate(Route.Search())
                },
                onRecentSearchClick = { recentSearch ->
                    navController.navigate(
                        Route.JourneyResults(
                            fromId = recentSearch.fromId,
                            fromName = recentSearch.fromName,
                            toId = recentSearch.toId,
                            toName = recentSearch.toName
                        )
                    )
                }
            )
        }

        composable<Route.Search> {
            SearchScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onSearchComplete = { fromId, fromName, toId, toName ->
                    navController.navigate(
                        Route.JourneyResults(
                            fromId = fromId,
                            fromName = fromName,
                            toId = toId,
                            toName = toName
                        )
                    ) {
                        popUpTo(Route.Landing)
                    }
                }
            )
        }

        composable<Route.JourneyResults> {
            JourneyResultsScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onRouteSelected = { lineId, lineName, fromName, toName ->
                    navController.navigate(
                        Route.BusList(
                            lineId = lineId,
                            lineName = lineName,
                            fromName = fromName,
                            toName = toName
                        )
                    )
                }
            )
        }

        composable<Route.BusList> {
            val route = it.toRoute<Route.BusList>()
            BusListScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onBusSelected = { vehicleId, naptanId, destinationName ->
                    navController.navigate(
                        Route.Tracking(
                            lineId = route.lineId,
                            lineName = route.lineName,
                            vehicleId = vehicleId,
                            destinationName = destinationName
                        )
                    )
                }
            )
        }

        composable<Route.Tracking> {
            TrackingScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
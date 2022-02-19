package com.example.aviationsystem.viewmodel

import androidx.lifecycle.*
import com.example.aviationsystem.model.daos.RouteDao
import com.example.aviationsystem.model.entities.Route
import kotlinx.coroutines.launch
import kotlin.math.roundToLong

/**
 * View Model to keep a reference to the GPA Calculator repository and an up-to-date list of all routes.
 *
 */
class RouteViewModel(private val routeDao: RouteDao) : ViewModel() {

    // Cache all routes from the database using LiveData
    val allRoutes: LiveData<List<Route>> = routeDao.getRoutes().asLiveData()

    // Updates an existing route in the database
    fun updateRoute(
        routeId: Int,
        sourceAirport: String,
        destinationAirport: String,
        routeDistance: Int,
        routeCost: Int
    ) {
        val updatedRoute = getUpdatedRouteEntry(routeId, sourceAirport, destinationAirport, routeDistance, routeCost)
        updateRoute(updatedRoute)
    }

    // Launching a new coroutine to update a route in a non-blocking way
    private fun updateRoute(route: Route) {
        viewModelScope.launch {
            routeDao.updateRoute(route)
        }
    }

    /*
    * Called to update an existing entry in the database.
    * Returns an  instance of the [Route] entity class with the route info updated by the user
     */
    private fun getUpdatedRouteEntry(
        routeId: Int,
        sourceAirport: String,
        destinationAirport: String,
        routeDistance: Int,
        routeCost: Int
    ): Route {
        return Route(
            routeId = routeId,
            sourceAirport = sourceAirport,
            destinationAirport = destinationAirport,
            routeDistance = routeDistance,
            routeCost = routeCost
        )
    }

    // Inserts the new Route into database
    fun addNewRoute(sourceAirport: String, destinationAirport: String, routeDistance: Int, routeCost: Int) {
        val newRoute = getNewRouteEntry(sourceAirport, destinationAirport, routeDistance, routeCost)
        insertRoute(newRoute)
    }

    /*
    * Called to updated an existing entry in the database.
    * Returns an instance of the [Route] entity class with the route info updadtedd by the user
     */
    private fun getNewRouteEntry(
        sourceAirport: String, destinationAirport: String, routeDistance: Int, routeCost: Int
    ): Route {
        return Route(
            sourceAirport = sourceAirport,
            destinationAirport = destinationAirport,
            routeDistance = routeDistance,
            routeCost = routeCost
        )
    }

    // Launching a new coroutine to insert a route in a non-blocking way
    private fun insertRoute(route: Route) {
        viewModelScope.launch {
            routeDao.insertRoute(route)
        }
    }

    // Launching a new coroutine to delete a route in a non-blocking way
    fun deleteRoute(route: Route) {
        viewModelScope.launch {
            routeDao.deleteRoute(route)
        }
    }

    // Retrieve a route from the repository
    fun retrieveRoute(id: Int): LiveData<Route> {
        return routeDao.getRoute(id).asLiveData()
    }

    // Returns true if the EditTexts are not empty
    fun isEntryValid(
        sourceAirport: String, destinationAirport: String, routeDistance: Int, routeCost: Int
    ): Boolean {
        return !(sourceAirport.isBlank() || destinationAirport.isBlank() || routeDistance.equals(0) || routeCost.equals(0))
    }

}

// Factory class to instantiate the [ViewModel] isntance.
class CalculatorViewModelFactory(private val routeDao: RouteDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RouteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RouteViewModel(routeDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
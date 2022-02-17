package com.example.aviationsystem.model.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.aviationsystem.model.entities.Airports
import com.example.aviationsystem.model.entities.Route

data class DestinationAirportsWithRoutes (
    @Embedded val airport: Airports,
    @Relation(
        parentColumn = "airportId",
        entityColumn = "routeId",
        associateBy = Junction(Destination::class)
    )
    val routes: List<Route>
)
package com.example.aviationsystem.model.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.aviationsystem.model.entities.Airport
import com.example.aviationsystem.model.entities.Route

data class DestinationRoutesWithAiroprts (
    @Embedded val route: Route,
    @Relation(
        parentColumn = "routeId",
        entityColumn = "airportId",
        associateBy = Junction(Destination::class)
    )
    val airports: List<Airport>
)
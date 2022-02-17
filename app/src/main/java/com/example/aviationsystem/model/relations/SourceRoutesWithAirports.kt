package com.example.aviationsystem.model.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.aviationsystem.model.entities.Airports
import com.example.aviationsystem.model.entities.Route

data class SourceRoutesWithAiroprts (
    @Embedded val route: Route,
    @Relation(
        parentColumn = "routeId",
        entityColumn = "airportId",
        associateBy = Junction(Source::class)
    )
    val airports: List<Airports>
)
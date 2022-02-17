package com.example.aviationsystem.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.aviationsystem.model.entities.Distance
import com.example.aviationsystem.model.entities.Route

data class DistancesWithRoute (
    @Embedded val distances: Distance,
    @Relation (
        parentColumn = "distanceId",
        entityColumn = "distanceId"
            )
    val routes: List<Route>
        )
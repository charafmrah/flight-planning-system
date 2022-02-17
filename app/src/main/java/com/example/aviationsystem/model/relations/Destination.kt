package com.example.aviationsystem.model.relations

import androidx.room.Entity

@Entity(primaryKeys = ["aiportId", "routeId"])
data class Destination (
    val airportId: Int,
    val routeId: Int,
)
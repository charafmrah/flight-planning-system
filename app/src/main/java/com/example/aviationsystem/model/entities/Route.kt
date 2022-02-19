package com.example.aviationsystem.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Route (
        @PrimaryKey(autoGenerate = true)
        val routeId: Int = 0,

        @ColumnInfo(name = "source_airport")
        val sourceAirport: String,

        @ColumnInfo(name = "destination_airport")
        val destinationAirport: String,

        @ColumnInfo(name = "cost")
        val routeCost: Int,

        @ColumnInfo(name = "distance")
        val routeDistance: Int
        )
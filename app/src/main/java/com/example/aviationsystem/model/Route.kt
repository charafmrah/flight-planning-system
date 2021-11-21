package com.example.aviationsystem.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Route (
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,
        @ColumnInfo(name = "source")
        val sourceCity: String,
        @ColumnInfo(name = "destination")
        val destinationCity: String,
        @ColumnInfo(name = "distance")
        val routeDistance: Int,
        @ColumnInfo(name = "cost")
        val routeCost: Int
        )
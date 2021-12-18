package com.example.aviationsystem.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Route (
        @PrimaryKey(autoGenerate = true)
        val routeId: Int = 0,
//        @ColumnInfo(name = "distance")
//        val routeDistance: Int,
        @ColumnInfo(name = "cost")
        val routeCost: Int
        )
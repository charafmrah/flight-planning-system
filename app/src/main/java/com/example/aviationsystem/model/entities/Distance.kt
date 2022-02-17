package com.example.aviationsystem.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Distance (
    @PrimaryKey(autoGenerate = true)
    val distanceId: Int,
    @ColumnInfo(name = "distance")
    val distance: String
        )
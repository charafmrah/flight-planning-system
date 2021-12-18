package com.example.aviationsystem.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Airports (
    @PrimaryKey(autoGenerate = true)
    val airportId: Int,
    @ColumnInfo(name = "airport")
    val airport: String
        )
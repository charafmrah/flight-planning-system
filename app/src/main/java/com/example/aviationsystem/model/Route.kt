package com.example.aviationsystem.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.aviationsystem.City

@Entity
data class Route (
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,
        @ColumnInfo(name = "source")
        val sourceCity: City,
        @ColumnInfo(name = "destination")
        val destinationCity: City,
        )
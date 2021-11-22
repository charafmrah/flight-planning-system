package com.example.aviationsystem.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cities (
    @PrimaryKey(autoGenerate = true)
    val cityId: Int,
    @ColumnInfo(name = "city")
    val city: String
        )
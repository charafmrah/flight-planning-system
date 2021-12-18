package com.example.aviationsystem.model.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Source (
        @PrimaryKey(autoGenerate = true)
        val sourceId: Int = 0,
        )

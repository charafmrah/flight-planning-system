package com.example.aviationsystem

import android.app.Application
import com.example.aviationsystem.model.databases.RouteRoomDatabase

class RouteApplication : Application() {
    val database: RouteRoomDatabase by lazy {
        RouteRoomDatabase.getDatabase(this)
    }
}
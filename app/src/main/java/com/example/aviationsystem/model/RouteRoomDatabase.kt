package com.example.aviationsystem.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aviationsystem.model.daos.RouteDao
import com.example.aviationsystem.model.entities.Route

@Database(entities = [Route::class], version = 1, exportSchema = false)
abstract class RouteRoomDatabase : RoomDatabase() {

    abstract fun routeDao(): RouteDao

    companion object {
        @Volatile
        private var INSTANCE: RouteRoomDatabase? = null

        fun getDatabase(context: Context): RouteRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RouteRoomDatabase::class.java,
                    "course_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}
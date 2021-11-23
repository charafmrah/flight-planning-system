package com.example.aviationsystem.model

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RouteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(route: Route)

    @Update
    suspend fun update(route: Route)

    @Delete
    suspend fun delete(route: Route)

    @Query("SELECT * FROM route WHERE routeId = :id")
    fun getRoute(id: Int): Flow<Route>

    @Query("SELECT * FROM route ")
    fun getRoutes(): Flow<List<Route>>

}
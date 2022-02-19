package com.example.aviationsystem.model.daos

import androidx.room.*
import com.example.aviationsystem.model.entities.Route
import kotlinx.coroutines.flow.Flow

@Dao
interface RouteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoute(route: Route)

    @Update
    suspend fun updateRoute(route: Route)

    @Delete
    suspend fun deleteRoute(route: Route)

    @Transaction
    @Query("SELECT * FROM route WHERE routeId = :routeId")
    fun getRoute(routeId: Int): Flow<Route>

    @Transaction
    @Query("SELECT * FROM route ORDER BY source_airport DESC")
    fun getRoutes(): Flow<List<Route>>
}
package com.example.aviationsystem.model

import androidx.room.*
import com.example.aviationsystem.City
import kotlinx.coroutines.flow.Flow

@Dao
interface RouteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(route: Route)

    @Update
    suspend fun update(route: Route)

    @Delete
    suspend fun delete(route: Route)

    @Query("SELECT * FROM route WHERE id = :id")
    fun getRoute(id: Int): Flow<Route>

    @Query("SELECT * FROM route ORDER BY source ASC")
    fun getRoutes(): Flow<List<Route>>

    @Query("SELECT source FROM route ORDER BY source ASC")
    fun getSources(): Flow<List<City>>
}
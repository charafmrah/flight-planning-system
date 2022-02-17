package com.example.aviationsystem.model.daos

import androidx.room.*
import com.example.aviationsystem.model.entities.Distances
import com.example.aviationsystem.model.entities.Route
import com.example.aviationsystem.model.relations.DistancesWithRoute

@Dao
interface RouteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDistance(distance: Distances)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoute(route: Route)

    @Transaction
    @Query("SELECT * FROM distances WHERE distanceId = :distancesId")
    suspend fun getDistancesWithRoute(distancesId: Int): List<DistancesWithRoute>
}
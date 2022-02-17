package com.example.aviationsystem.model.daos

import androidx.room.*
import com.example.aviationsystem.model.entities.Airport
import com.example.aviationsystem.model.entities.Distance
import com.example.aviationsystem.model.entities.Route
import com.example.aviationsystem.model.relations.Destination
import com.example.aviationsystem.model.relations.DistancesWithRoute
import com.example.aviationsystem.model.relations.Source

@Dao
interface RouteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAirport(airport: Airport)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDistance(distance: Distance)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoute(route: Route)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSource(source: Source)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSource(destination: Destination)

    @Transaction
    @Query("SELECT * FROM distance WHERE distanceId = :distancesId")
    suspend fun getDistancesWithRoute(distancesId: Int): List<DistancesWithRoute>

}
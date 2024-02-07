package net.arx.helloworldarx.data.tmdb.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "listOfMovies")
data class LocalListOfMovies(
    @PrimaryKey(autoGenerate = true)
    val listId: Int?,
    val page: Int?,
    val results: List<LocalDashboardMovie>?
)
package net.arx.helloworldarx.data.tmdb.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1, //LocalListOfMovies::class
    entities = [LocalMovie::class,LocalMovieCredits::class], // TODO Add your own entities here like [LocalMovie::class, Categories::class, DashboardStuff::class]
    exportSchema = false
    )
//@TypeConverters(LocalDashboardMovieConverter::class)
    abstract class TmdbDatabase : RoomDatabase() {
        abstract fun tmdbDao(): TmdbDao
}


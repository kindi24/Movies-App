package net.arx.helloworldarx.data.tmdb.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LocalDashboardMovieConverter {
   /* companion object {
        @TypeConverter
        @JvmStatic
        fun fromLocalDashboardMoviesList(list: List<LocalDashboardMovie>?): String? {
            val gson = Gson()
            return gson.toJson(list)
        }

        @TypeConverter
        @JvmStatic
        fun toLocalDashboardMoviesList(json: String?): List<LocalDashboardMovie>? {
            val gson = Gson()
            val type = object : TypeToken<List<LocalDashboardMovie>>() {}.type
            return gson.fromJson(json, type)
        }
    }*/
}
package net.arx.helloworldarx.framework.tmdb.datasource

import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataSource
import net.arx.helloworldarx.framework.tmdb.api.TmdbApi
import javax.inject.Inject


class TmdbDataSourceImpl @Inject constructor(
    private val tmdbApi: TmdbApi
) : TmdbDataSource {

}
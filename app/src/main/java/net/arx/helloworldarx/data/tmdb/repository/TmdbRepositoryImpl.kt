package net.arx.helloworldarx.data.tmdb.repository

import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataSource
import net.arx.helloworldarx.domain.tmdb.repository.TmdbRepository
import javax.inject.Inject

class TmdbRepositoryImpl @Inject constructor(
    private val dataSource: TmdbDataSource
) : TmdbRepository {


}
package net.arx.helloworldarx.domain.tmdb.repository

import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.data.tmdb.local.LocalMovieCredits
import net.arx.helloworldarx.data.tmdb.model.RemoteTmdbCredits

sealed class TmdbMovieCreditsResult {

    class DefaultResult(val movieCredits: List<LocalMovieCredits>): TmdbMovieCreditsResult()

    object ErrorResult: TmdbMovieCreditsResult()

}
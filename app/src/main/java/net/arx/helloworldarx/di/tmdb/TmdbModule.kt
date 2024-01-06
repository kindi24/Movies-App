package net.arx.helloworldarx.di.tmdb

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.arx.helloworldarx.BuildConfig
import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataSource
import net.arx.helloworldarx.data.tmdb.repository.TmdbRepositoryImpl
import net.arx.helloworldarx.di.qualifier.TmdbApiOkHttpClient
import net.arx.helloworldarx.domain.tmdb.repository.TmdbRepository
import net.arx.helloworldarx.framework.tmdb.api.TmdbApi
import net.arx.helloworldarx.framework.tmdb.datasource.TmdbDataSourceImpl
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TmdbModule {

    @Singleton
    @Provides
    @TmdbApiOkHttpClient
    fun provideTmdbApiOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        connectionSpec: ConnectionSpec
    ): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectionSpecs(listOf(connectionSpec))

        if (BuildConfig.DEBUG) {
            okHttpClient.addNetworkInterceptor(httpLoggingInterceptor)
        }

        return okHttpClient.build()
    }

    @Singleton
    @Provides
    fun provideTmdbApi(
        converterFactory: MoshiConverterFactory,
        @TmdbApiOkHttpClient okHttpClient: OkHttpClient
    ): TmdbApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.TMDB_HOST_NAME)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
            .create(TmdbApi::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
interface TmdbBindsModule {

    @Binds
    fun bindTmdbRepositoryImpl(repository: TmdbRepositoryImpl): TmdbRepository

    @Binds
    fun bindTmdbDataSourceImpl(dataSource: TmdbDataSourceImpl): TmdbDataSource
}
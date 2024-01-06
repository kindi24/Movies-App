package net.arx.helloworldarx.di.core

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.arx.helloworldarx.util.HELLO_WORLD_IHU_ARX_PREFS
import net.arx.helloworldarx.util.encryptor.Encryptor
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object StorageModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return EncryptedSharedPreferences.create(
            context,
            HELLO_WORLD_IHU_ARX_PREFS,
            Encryptor.masterKeyAlias(context),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }
}
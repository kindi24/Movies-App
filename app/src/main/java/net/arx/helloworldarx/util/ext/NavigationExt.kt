package net.arx.helloworldarx.util.ext

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import timber.log.Timber

/*
 * prevent open 2 times
 */
fun NavController.singleNavigate(destinationResId: Int, args: Bundle? = null, navOptions: NavOptions? = null) {
    try {
        if (currentDestination?.id != destinationResId) {
            navigate(destinationResId, args, navOptions)
        }
    } catch (e: Exception) {
        Timber.tag("Navigation").e(e)
    }
}
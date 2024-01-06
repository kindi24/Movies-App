package net.arx.helloworldarx.util.ext

import android.content.res.Resources
import android.util.TypedValue
import kotlin.math.roundToInt


object ViewUtil {

    fun dpToPx(dp: Float): Int {
        val density = Resources.getSystem().displayMetrics.density
        return (dp * density).roundToInt()
    }

    fun spToPx(sp: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, Resources.getSystem().displayMetrics).toInt()
    }

    val Int.pxToDp: Int
        get() = (this / Resources.getSystem().displayMetrics.density).toInt()

}
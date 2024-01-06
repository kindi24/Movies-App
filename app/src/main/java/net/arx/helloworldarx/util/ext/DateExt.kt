package net.arx.helloworldarx.util.ext

import android.text.format.DateUtils
import net.arx.helloworldarx.util.DATE
import net.arx.helloworldarx.util.HOUR
import net.arx.helloworldarx.util.STRING_FULL_MONTH
import net.arx.helloworldarx.util.YEAR
import java.text.SimpleDateFormat
import java.util.*

fun Date.toHour(format: String = HOUR): Int {
    return try {
        SimpleDateFormat(format, Locale.getDefault()).format(this).toInt()
    } catch (e: java.lang.Exception) {
        -1
    }
}

fun Date.toStringDate(format: String = HOUR): String {
    return try {
        SimpleDateFormat(format, Locale.getDefault()).format(this)
    } catch (e: java.lang.Exception) {
        ""
    }
}

fun Long.toDate(format: String = DATE): String {
    return try {
        SimpleDateFormat(format, Locale.getDefault()).format(this)
    } catch (e: Exception) {
        ""
    }
}

fun Long.toMonthYear(): String {
    return try {
        val month = SimpleDateFormat(STRING_FULL_MONTH, Locale.getDefault()).format(this)
        val year = SimpleDateFormat(YEAR, Locale.getDefault()).format(this)
        "$month $year"
    } catch (e: Exception) {
        ""
    }
}

fun isYesterday(whenInMillis: Long): Boolean {
    return DateUtils.isToday(whenInMillis + DateUtils.DAY_IN_MILLIS)
}

fun isToday(whenInMillis: Long): Boolean {
    return DateUtils.isToday(whenInMillis)
}

val Long?.toMillis: Long?
    get() = when {
        this != null -> this * 1000
        else -> null
    }

fun dateInMillis(year: Int, month: Int, dayOfMonth: Int, hour: Int, minute: Int, second: Int): Long =
    Calendar.getInstance().apply {
        set(year, month, dayOfMonth, hour, minute, second)
    }.timeInMillis

fun String.convertDateFormat(sourcePattern: String, desiredPattern: String): String {
    val sourceDateFormat = SimpleDateFormat(sourcePattern, Locale.getDefault())
    val desiredDateFormat = SimpleDateFormat(desiredPattern, Locale.getDefault())
    return try {
        val date = sourceDateFormat.parse(this)
        date?.let { desiredDateFormat.format(date) } ?: ""
    } catch (e: java.lang.Exception) {
        e.printStackTrace()
        ""
    }
}

fun String.dateToTimestamp(sourcePattern: String): Long? {
    return try {
        SimpleDateFormat(sourcePattern, Locale.getDefault()).parse(this)?.time
    } catch (ex: Exception) {
        null
    }
}
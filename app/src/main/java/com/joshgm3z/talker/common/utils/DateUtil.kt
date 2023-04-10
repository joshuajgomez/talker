package com.joshgm3z.talker.common.utils

import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

fun getPrettyTime(time: Long): String {
    val date = Date(time)
//    var pattern = "dd/MM/YY"
    var pattern = "hh:mm a"
    if (DateUtils.isToday(time)) {
        pattern = "hh:mm a"
    }
    var format = SimpleDateFormat(pattern)
    return format.format(date)
}
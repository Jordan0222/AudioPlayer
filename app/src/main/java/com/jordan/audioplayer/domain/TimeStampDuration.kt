package com.jordan.audioplayer.domain

import kotlin.math.floor

class TimeStampDuration {
    operator fun invoke(duration: Long): String {
        val totalSeconds = floor(duration / 1E3).toInt()
        val minutes = totalSeconds / 60
        val remainingSeconds = totalSeconds - (minutes * 60)

        return if (duration < 0) "--:--"
        else "%d:%02d".format(minutes, remainingSeconds)
    }
}
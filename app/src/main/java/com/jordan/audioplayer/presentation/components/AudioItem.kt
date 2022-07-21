package com.jordan.audioplayer.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jordan.audioplayer.data.model.Audio
import com.jordan.audioplayer.ui.theme.TimeColor
import com.jordan.audioplayer.util.LocalSpacing
import kotlin.math.floor

@Composable
fun AudioItem(
    audio: Audio,
    onItemClick: (id: Long) -> Unit,
    audioPlaying: Boolean
) {
    val spacing = LocalSpacing.current

    Row(
        modifier =  Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clickable {
                onItemClick.invoke(audio.id)
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(spacing.spaceMedium))
        PlayerIconItem(
            icon = Icons.Default.MusicNote,
            border = BorderStroke(
                width = 1.dp,
                color = if (audioPlaying) {
                    TimeColor
                } else {
                    MaterialTheme.colors.onSurface.copy(
                        alpha = 0.9f
                    )
                }
            ),
            modifier = Modifier.size(spacing.spaceLarge),
            backgroundColor = MaterialTheme.colors.background,
            color = if (audioPlaying) {
                TimeColor
            } else {
                MaterialTheme.colors.onSurface.copy(
                    alpha = 0.9f
                )
            }
        ) {}
        Spacer(modifier = Modifier.width(spacing.spaceMedium))
        Text(
            text = audio.displayName,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colors.onSurface.copy(
                alpha = 0.9f
            )
        )
        Spacer(modifier = Modifier.width(spacing.spaceMedium))
        Text(
            text = timeStampToDuration(audio.duration.toLong()),
            color = TimeColor
        )
        Spacer(modifier = Modifier.width(spacing.spaceSmall))
    }
}

private fun timeStampToDuration(duration: Long): String {
    val totalSeconds = floor(duration / 1E3).toInt()
    val minutes = totalSeconds / 60
    val remainingSeconds = totalSeconds - (minutes * 60)

    return if (duration < 0) "--:--"
        else "%d:%02d".format(minutes, remainingSeconds)
}
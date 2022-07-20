package com.jordan.audioplayer.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.jordan.audioplayer.data.model.Audio
import kotlin.math.floor

@Composable
fun AudioItem(
    audio: Audio,
    onItemClick: (id: Long) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                onItemClick.invoke(audio.id)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = audio.displayName,
                    style = MaterialTheme.typography.h6,
                    overflow = TextOverflow.Clip,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = audio.artist,
                    style = MaterialTheme.typography.subtitle1,
                    maxLines = 1,
                    overflow = TextOverflow.Clip,
                    color = MaterialTheme.colors
                        .onSurface
                        .copy(
                            alpha = 0.5f
                        )
                )
            }
            Text(
                text = timeStampToDuration(audio.duration.toLong())
            )
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
}

private fun timeStampToDuration(duration: Long): String {
    val totalSeconds = floor(duration / 1E3).toInt()
    val minutes = totalSeconds / 60
    val remainingSeconds = totalSeconds - (minutes * 60)

    return if (duration < 0) "--:--"
        else "%d:%02d".format(minutes, remainingSeconds)
}
package com.jordan.audioplayer.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Equalizer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.jordan.audioplayer.domain.model.Audio
import com.jordan.audioplayer.domain.use_case.TimeStampDuration
import com.jordan.audioplayer.ui.theme.BlueLight
import com.jordan.audioplayer.util.LocalSpacing

private val audio = Audio(
        uri = "".toUri(),
        displayName = "Kotlin Programming",
        id = 0L,
        artist = "Hood",
        data = "",
        duration = 12345,
        title = "Android Programming"
)

@Composable
fun BottomBarPlayer(
    progress: Float,
    onProgressChange: (Float) -> Unit,
    currentPosition: Long,
    audio: Audio,
    isAudioPlaying: Boolean,
    onStart: () -> Unit,
    onNext: () -> Unit,
    onPrevious: () -> Unit,
    onForward10: () -> Unit,
    onRewind10: () -> Unit
) {
    val spacing = LocalSpacing.current
    val timeStampDuration = TimeStampDuration()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.width(spacing.spaceMedium))
            PlayerIconItem(
                icon = Icons.Default.Equalizer,
                border = BorderStroke(
                    width = 1.dp,
                    color = BlueLight
                ),
                modifier = Modifier.size(spacing.spaceLarge),
                backgroundColor = MaterialTheme.colors.background,
                color = BlueLight
            ) {}
            ArtistInfo(
                audio = audio,
                modifier = Modifier
                    .height(spacing.sheetPeekHeight)
                    .weight(1f)
            )
        }
        MediaPlayerController(
            isAudioPlaying = isAudioPlaying,
            onStart = { onStart.invoke() },
            onNext = { onNext.invoke() },
            onPrevious = { onPrevious.invoke() },
            onForward10 = { onForward10.invoke() },
            onRewind10 = { onRewind10.invoke() }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(spacing.spaceMedium))
            Text(
                text = timeStampDuration(currentPosition),
                color = MaterialTheme.colors.onSurface,
                fontWeight = FontWeight.Bold
            )
            Slider(
                value = progress,
                onValueChange = { onProgressChange.invoke(it) },
                valueRange = 0f..100f,
                modifier = Modifier
                    .padding(horizontal = spacing.spaceSmall)
                    .weight(1f)
            )
            Text(
                text = timeStampDuration(audio.duration.toLong()),
                color = MaterialTheme.colors.onSurface,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(spacing.spaceMedium))
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun BottomBarPrev() {
    AudioPlayerTheme {
        BottomBarPlayer(
            progress = 50f,
            onProgressChange = {},
            audio = audio,
            isAudioPlaying = true,
            onStart = { *//*TODO*//* }) {
        }
    }
}*/

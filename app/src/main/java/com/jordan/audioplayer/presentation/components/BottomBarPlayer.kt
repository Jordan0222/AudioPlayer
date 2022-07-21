package com.jordan.audioplayer.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Equalizer
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.jordan.audioplayer.data.model.Audio
import com.jordan.audioplayer.ui.theme.AudioPlayerTheme
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
    audio: Audio,
    isAudioPlaying: Boolean,
    onStart: () -> Unit,
    onNext: () -> Unit,
    onPrevious: () -> Unit,
    onForward10: () -> Unit,
    onRewind10: () -> Unit
) {
    val spacing = LocalSpacing.current

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
        Slider(
            value = progress,
            onValueChange = { onProgressChange.invoke(it) },
            valueRange = 0f..100f,
            modifier = Modifier.padding(horizontal = spacing.spaceSmall)
        )
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

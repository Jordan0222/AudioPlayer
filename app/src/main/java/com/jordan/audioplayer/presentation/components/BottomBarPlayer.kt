package com.jordan.audioplayer.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.jordan.audioplayer.data.model.Audio
import com.jordan.audioplayer.ui.theme.AudioPlayerTheme

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
    onNext: () -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ArtistInfo(
                audio = audio,
                modifier = Modifier.weight(1f)
            )
            MediaPlayerController(
                isAudioPlaying = isAudioPlaying,
                onStart = { onStart.invoke() },
                onNext = { onNext.invoke() }
            )
        }
        Slider(
            value = progress,
            onValueChange = { onProgressChange.invoke(it) },
            valueRange = 0f..100f
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPrev() {
    AudioPlayerTheme {
        BottomBarPlayer(
            progress = 50f,
            onProgressChange = {},
            audio = audio,
            isAudioPlaying = true,
            onStart = { /*TODO*/ }) {
        }
    }
}

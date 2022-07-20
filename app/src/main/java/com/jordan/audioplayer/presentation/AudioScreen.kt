package com.jordan.audioplayer.presentation

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import com.jordan.audioplayer.data.model.Audio
import com.jordan.audioplayer.presentation.components.AudioItem
import com.jordan.audioplayer.presentation.components.BottomBarPlayer
import com.jordan.audioplayer.ui.theme.AudioPlayerTheme


private val dummyAudioList = listOf(
    Audio(
        uri = "".toUri(),
        displayName = "Kotlin Programming",
        id = 0L,
        artist = "Hood",
        data = "",
        duration = 12345,
        title = "Android Programming"
    ),
    Audio(
        uri = "".toUri(),
        displayName = "Kotlin Programming",
        id = 0L,
        artist = "Lab",
        data = "",
        duration = 25678,
        title = "Android Programming"
    ),
    Audio(
        uri = "".toUri(),
        displayName = "Kotlin Programming",
        id = 0L,
        artist = "Android Lab",
        data = "",
        duration = 8765454,
        title = "Android Programming"
    ),
    Audio(
        uri = "".toUri(),
        displayName = "Kotlin Programming",
        id = 0L,
        artist = "Kotlin Lab",
        data = "",
        duration = 23456,
        title = "Android Programming"
    ),
    Audio(
        uri = "".toUri(),
        displayName = "Kotlin Programming",
        id = 0L,
        artist = "Hood Lab",
        data = "",
        duration = 65788,
        title = "Android Programming"
    ),
    Audio(
        uri = "".toUri(),
        displayName = "Kotlin Programming",
        id = 0L,
        artist = "Hood Lab",
        data = "",
        duration = 234567,
        title = "Android Programming"
    ),
)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AudioListScreen(
    audioViewModel: AudioViewModel = hiltViewModel()
) {
    val scaffoldState = rememberBottomSheetScaffoldState()
    val state = audioViewModel.audioState

    val animatedHeight by animateDpAsState(
        targetValue = if (audioViewModel.currentPlayingAudio.value == null) 0.dp
                    else BottomSheetScaffoldDefaults.SheetPeekHeight
    )

    BottomSheetScaffold(
        sheetContent = {
            audioViewModel.currentPlayingAudio.value?.let {
                BottomBarPlayer(
                    progress = audioViewModel.currentAudioProgress.value,
                    onProgressChange = {
                       audioViewModel.seekTo(it)
                    },
                    audio = audioViewModel.currentPlayingAudio.value!!,
                    isAudioPlaying = audioViewModel.isAudioPlaying,
                    onStart = {
                        audioViewModel.playAudio(it)
                    },
                    onNext = {
                        audioViewModel.skipToNext()
                    }
                )
            }
        },
        scaffoldState = scaffoldState,
        sheetPeekHeight = animatedHeight
    ) {
        LazyColumn(
            contentPadding = PaddingValues(bottom = 56.dp)
        ) {
            items(state.audioList) { audio ->
                AudioItem(
                    audio = audio,
                    onItemClick = {
                        audioViewModel.playAudio(audio)
                    }
                )
            }
        }
    }
}
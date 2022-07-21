package com.jordan.audioplayer.presentation

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import com.jordan.audioplayer.data.model.Audio
import com.jordan.audioplayer.presentation.components.AudioItem
import com.jordan.audioplayer.presentation.components.BottomBarPlayer
import com.jordan.audioplayer.util.LocalSpacing
import kotlinx.coroutines.launch


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
    val spacing = LocalSpacing.current

    val state = audioViewModel.audioState

    val animatedHeight by animateDpAsState(
        targetValue = if (audioViewModel.currentPlayingAudio.value == null) {
            spacing.default
        } else BottomSheetScaffoldDefaults.SheetPeekHeight
    )

    BottomSheetScaffold(
        sheetContent = {
            audioViewModel.currentPlayingAudio.value?.let { audio ->
                BottomBarPlayer(
                    progress = audioViewModel.currentAudioProgress.value,
                    onProgressChange = { progress ->
                       audioViewModel.seekTo(progress)
                    },
                    currentPosition = audioViewModel.currentPlayBackPosition,
                    audio = audio,
                    isAudioPlaying = audioViewModel.isAudioPlaying,
                    onStart = {
                        audioViewModel.playAudio(audio)
                    },
                    onNext = {
                        audioViewModel.skipToNext()
                    },
                    onPrevious = {
                        audioViewModel.skipToPrevious()
                    },
                    onForward10 = {
                        audioViewModel.fastForward()
                    },
                    onRewind10 = {
                        audioViewModel.rewind()
                    }
                )
            }
        },
        scaffoldState = scaffoldState,
        sheetPeekHeight = animatedHeight
    ) {
        LazyColumn(
            contentPadding = PaddingValues(
                bottom = spacing.sheetPeekHeight
            )
        ) {
            items(state.audioList.size) { i ->
                val audio = state.audioList[i]
                val audioPlaying = audioViewModel.currentPlayingAudio.value == audio
                AudioItem(
                    audio = audio,
                    onItemClick = {
                        audioViewModel.playAudio(audio)
                    },
                    audioPlaying = audioPlaying
                )
                if (i < state.audioList.size - 1) {
                    Divider(
                        color = MaterialTheme.colors.onSurface.copy(
                            alpha = 0.9f
                        )
                    )
                }
            }
        }
    }
}
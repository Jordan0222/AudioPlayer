package com.jordan.audioplayer.presentation

import com.jordan.audioplayer.data.model.Audio

data class AudioState(
    val audioList: List<Audio> = emptyList()
)
package com.jordan.audioplayer.presentation

import com.jordan.audioplayer.domain.model.Audio

data class AudioState(
    val audioList: List<Audio> = emptyList(),
    val isExpand : Boolean = false
)
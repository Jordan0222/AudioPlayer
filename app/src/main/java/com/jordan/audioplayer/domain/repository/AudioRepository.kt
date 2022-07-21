package com.jordan.audioplayer.domain.repository

import com.jordan.audioplayer.domain.model.Audio

interface AudioRepository {

    suspend fun getAudioData(): List<Audio>
}
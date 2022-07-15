package com.jordan.audioplayer.data.repository

import com.jordan.audioplayer.data.ContentResolverHelper
import com.jordan.audioplayer.data.model.Audio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AudioRepository @Inject constructor(
    private val contentResolverHelper: ContentResolverHelper
){
    suspend fun getAudioData(): List<Audio> = withContext(Dispatchers.IO) {
        contentResolverHelper.getAudioData()
    }
}
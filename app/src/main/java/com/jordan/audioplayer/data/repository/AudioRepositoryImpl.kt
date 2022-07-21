package com.jordan.audioplayer.data.repository

import com.jordan.audioplayer.data.ContentResolverHelper
import com.jordan.audioplayer.domain.model.Audio
import com.jordan.audioplayer.domain.repository.AudioRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AudioRepositoryImpl @Inject constructor(
    private val contentResolverHelper: ContentResolverHelper
): AudioRepository {

    override suspend fun getAudioData(): List<Audio> = withContext(Dispatchers.IO) {
        contentResolverHelper.getAudioData()
    }
}
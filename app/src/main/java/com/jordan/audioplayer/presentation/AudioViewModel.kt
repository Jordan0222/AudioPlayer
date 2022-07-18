package com.jordan.audioplayer.presentation

import android.support.v4.media.MediaBrowserCompat
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jordan.audioplayer.data.model.Audio
import com.jordan.audioplayer.data.repository.AudioRepository
import com.jordan.audioplayer.media.constants.K
import com.jordan.audioplayer.media.exoplayer.MediaPlayerServiceConnection
import com.jordan.audioplayer.media.exoplayer.currentPosition
import com.jordan.audioplayer.media.exoplayer.isPlaying
import com.jordan.audioplayer.media.service.MediaPlayerService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


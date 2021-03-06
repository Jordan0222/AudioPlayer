package com.jordan.audioplayer.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.jordan.audioplayer.util.LocalSpacing

@Composable
fun MediaPlayerController(
    isAudioPlaying: Boolean,
    onStart: () -> Unit,
    onNext: () -> Unit,
    onPrevious: () -> Unit,
    onForward10: () -> Unit,
    onRewind10: () -> Unit
) {
    val spacing = LocalSpacing.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(spacing.spaceExtraSmall),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.SkipPrevious,
            contentDescription = null,
            modifier = Modifier
                .clickable {
                    onPrevious.invoke()
                }
                .size(spacing.spaceLarge)
        )

        Spacer(modifier = Modifier.width(spacing.spaceSmall))

        Icon(
            imageVector = Icons.Default.Replay10,
            contentDescription = null,
            modifier = Modifier
                .clickable {
                    onRewind10.invoke()
                }
                .size(spacing.spaceLarge)
        )

        Spacer(modifier = Modifier.width(spacing.spaceSmall))

        PlayerIconItem(
            icon = if (isAudioPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
            backgroundColor = MaterialTheme.colors.background,
            modifier = Modifier.size(spacing.spaceLarge),
            border = BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colors.onSurface
            )
        ) {
            onStart.invoke()
        }

        Spacer(modifier = Modifier.width(spacing.spaceSmall))

        Icon(
            imageVector = Icons.Default.Forward10,
            contentDescription = null,
            modifier = Modifier
                .clickable {
                    onForward10.invoke()
                }
                .size(spacing.spaceLarge)
        )

        Spacer(modifier = Modifier.width(spacing.spaceSmall))

        Icon(
            imageVector = Icons.Default.SkipNext,
            contentDescription = null,
            modifier = Modifier
                .clickable {
                    onNext.invoke()
                }
                .size(spacing.spaceLarge)
        )
    }
}
package com.jordan.audioplayer.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.jordan.audioplayer.domain.model.Audio
import com.jordan.audioplayer.util.LocalSpacing

@Composable
fun ArtistInfo(
    modifier: Modifier = Modifier,
    audio: Audio
) {
    val spacing = LocalSpacing.current

    Row(
        modifier = modifier
            .padding(spacing.spaceSmall)
            .height(spacing.sheetPeekHeight),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(spacing.spaceSmall))
        Text(
            text = audio.displayName,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colors.onSurface.copy(
                alpha = 0.9f
            )
        )
    }
}
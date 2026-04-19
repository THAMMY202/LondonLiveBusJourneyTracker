package com.tracker.londonbusjourney.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tracker.londonbusjourney.R
import com.tracker.londonbusjourney.ui.theme.ComponentSize
import com.tracker.londonbusjourney.ui.theme.CornerRadius
import com.tracker.londonbusjourney.ui.theme.Elevation
import com.tracker.londonbusjourney.ui.theme.IconSize
import com.tracker.londonbusjourney.ui.theme.Spacing
import com.tracker.londonbusjourney.ui.theme.TextTertiary

@Composable
fun LandingSearchBar(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(ComponentSize.searchBarHeight)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(CornerRadius.large),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = Elevation.medium,
        tonalElevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Spacing.default),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                modifier = Modifier.size(IconSize.default),
                tint = TextTertiary
            )

            Spacer(modifier = Modifier.width(Spacing.medium))

            Text(
                text = stringResource(R.string.search_placeholder),
                style = MaterialTheme.typography.bodyLarge,
                color = TextTertiary
            )
        }
    }
}
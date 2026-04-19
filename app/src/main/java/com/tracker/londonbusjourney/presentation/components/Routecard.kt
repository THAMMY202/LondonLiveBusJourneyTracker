package com.tracker.londonbusjourney.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tracker.londonbusjourney.R
import com.tracker.londonbusjourney.ui.theme.BusYellow
import com.tracker.londonbusjourney.ui.theme.ComponentSize
import com.tracker.londonbusjourney.ui.theme.CornerRadius
import com.tracker.londonbusjourney.ui.theme.IconSize
import com.tracker.londonbusjourney.ui.theme.Spacing
import com.tracker.londonbusjourney.ui.theme.TextOnYellow
import com.tracker.londonbusjourney.ui.theme.TextPrimary
import com.tracker.londonbusjourney.ui.theme.TextSecondary

@Composable
fun RouteHistoryCard(
    routeNumber: String,
    viaDescription: String,
    durationMinutes: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        color = MaterialTheme.colorScheme.surface
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = Spacing.default,
                    vertical = Spacing.medium
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(ComponentSize.busIconContainer)
                    .clip(RoundedCornerShape(CornerRadius.medium))
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_route),
                    contentDescription = null,
                    modifier = Modifier.size(IconSize.default),
                    tint = Color.Unspecified  // Use original icon colors
                )
            }

            Spacer(modifier = Modifier.width(Spacing.medium))

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Route $routeNumber",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimary
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = viaDescription,
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextSecondary
                )
            }

            Spacer(modifier = Modifier.width(Spacing.small))

            TimeBadge(minutes = durationMinutes)
        }
    }
}

@Composable
fun TimeBadge(
    minutes: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(ComponentSize.timeBadgeWidth)
            .height(ComponentSize.timeBadgeHeight)
            .clip(RoundedCornerShape(CornerRadius.small))
            .background(BusYellow),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "$minutes",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = TextOnYellow
            )
            Text(
                text = "Min",
                style = MaterialTheme.typography.labelSmall,
                color = TextOnYellow
            )
        }
    }
}
package com.tracker.londonbusjourney

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tracker.londonbusjourney.ui.theme.LondonLiveBusJourneyTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LondonLiveBusJourneyTrackerTheme {
            }
        }
    }
}
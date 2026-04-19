package com.tracker.londonbusjourney

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tracker.londonbusjourney.ui.theme.LondonBusTheme
import dagger.hilt.android.AndroidEntryPoint
import com.tracker.londonbusjourney.presentation.navigation.AppNavHost
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LondonBusTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavHost()

                }
            }
        }
    }
}
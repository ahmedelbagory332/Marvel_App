package com.example.presentation.common

import android.os.Build
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat


@Composable
fun ChangeStatusColor() {
    // Get the current activity context
    val context = LocalActivity.current as? ComponentActivity
    // Set the status bar to black and icons to white
    context?.let {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            it.window.insetsController?.setSystemBarsAppearance(
                0,
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            )
        } else {
            WindowCompat.getInsetsController(it.window, it.window.decorView).apply {
                isAppearanceLightStatusBars = false
            }
        }
    }
}

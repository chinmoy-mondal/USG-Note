package com.purnota.usgnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Install splash screen
        installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Optional: If you want a short delay, you can keep it here
        // Otherwise, the splash screen disappears instantly
    }
}
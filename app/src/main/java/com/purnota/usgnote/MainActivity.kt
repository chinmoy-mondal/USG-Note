package com.purnota.usgnote

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.widget.addTextChangedListener
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        //        Explicit Intent
        val explicitButton = findViewById<Button>(R.id.explicitButton)

        explicitButton.setOnClickListener {
            val explicitIntent = Intent(this,SecondActivity::class.java)
            startActivity(explicitIntent)
            finish()
        }


        //        Implicit Intent
        val url = "https://www.google.com"
        val implicitButton = findViewById<Button>(R.id.implicitButton)

        implicitButton.setOnClickListener {
            val  implicitIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(implicitIntent)
        }

    }
}
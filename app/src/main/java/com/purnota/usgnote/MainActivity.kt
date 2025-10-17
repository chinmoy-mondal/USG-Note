package com.purnota.usgnote

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.widget.addTextChangedListener
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Install splash screen
        val splashScreen: SplashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Keep splash for 2 seconds
        var keepSplashOnScreen = true
        splashScreen.setKeepOnScreenCondition { keepSplashOnScreen }
        window.decorView.postDelayed({
            keepSplashOnScreen = false
        }, 2000)

        // Setup toolbar
        val toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        toolbar.setNavigationOnClickListener {
            // You can open drawer or show a menu here
        }

        // Setup search and list
        setupSearchAndList()
    }

    private fun setupSearchAndList() {
        val searchBar = findViewById<TextInputEditText>(R.id.searchBar)
        val listView = findViewById<ListView>(R.id.listView)

        val items = listOf(
            "Mathematics",
            "English",
            "Physics",
            "Chemistry",
            "Biology",
            "Computer Science",
            "Economics",
            "History",
            "Geography",
            "Civics"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        listView.adapter = adapter

        searchBar.addTextChangedListener { text ->
            val filtered = items.filter { it.contains(text.toString(), ignoreCase = true) }
            listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, filtered)
        }
    }
}
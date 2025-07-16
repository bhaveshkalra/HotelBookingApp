package com.example.hotelbooking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.hotelbooking.databinding.ActivityMainBinding

/**
 * 🛠️ PROJECT: Hotel Booking App
 * Screen	Features
 * 🔍 Search Screen	Date & Location input
 * 🏨 Hotel List Screen	Fetch list from dummy API
 * 📄 Details + Book Now	Book hotel & save locally
 * 📘 My Bookings Screen	Show bookings from Room DB
 *
 * ✅ TECHNOLOGY STACK:
 * Architecture: MVVM
 * UI: ViewBinding + RecyclerView
 * Data: Retrofit (JSON API) + Room
 * Threading: Coroutines + suspend (after base done)**/

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up NavHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        // Optional: For showing action bar back arrow
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        return navHostFragment.navController.navigateUp() || super.onSupportNavigateUp()
    }
}
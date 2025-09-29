package com.example.zzzcompanionapp

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Carrega AgentsFragment ao abrir
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, AgentsFragment())
            .commit()

        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_agents -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, AgentsFragment())
                        .commit()
                    true
                }
                R.id.nav_settings -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SettingsFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}

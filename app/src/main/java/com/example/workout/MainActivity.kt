package com.example.workout

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.workout.activities.ExerciseActivity
import com.example.workout.activities.NutritionActivity
import com.example.workout.activities.ProfileActivity
import com.example.workout.databinding.ActivityMainBinding
import com.example.workout.ui.home.CustomMultiSelectionDialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weeklyCalender.setOnClickListener {
            startActivity(Intent(this@MainActivity, CustomMultiSelectionDialog::class.java))
            finish()
        }

        /*
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.profileFragment, R.id.navigation_nutrition
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

         */

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.nav_view)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_main_activity-> {

                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.navigation_exercise_activity -> {

                    startActivity(Intent(this, ExerciseActivity::class.java))
                    true
                }
                R.id.navigation_profile_activity -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                R.id.navigation_nutrition_activity -> {
                    startActivity(Intent(this, NutritionActivity::class.java))
                    true
                }
                else -> false
            }
        }

    }
}
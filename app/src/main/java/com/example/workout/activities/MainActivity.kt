package com.example.workout.activities

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.workout.R
import com.example.workout.database.ExerciseViewModel
import com.example.workout.databinding.ActivityMainBinding

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
            startActivity(Intent(this@MainActivity, ExerciseSelectionActivity::class.java))
            finish()
        }


        // TODO remove the findViewBYId an put Binding
        val bottomNavigationView: BottomNavigationView = binding.navView

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_main_activity -> {

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
package com.example.workout.ui.calender

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.workout.database.ExerciseViewModel
import com.example.workout.databinding.ActivityHomeBinding
import com.example.workout.databinding.ActivityMainBinding
import com.example.workout.databinding.FragmentNotificationsBinding

class HomeCalender : AppCompatActivity()  {

    private lateinit var binding : ActivityHomeBinding

    private lateinit var mUserViewModel: ExerciseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
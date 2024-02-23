package com.example.workout.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.workout.database.data.Exercise
import com.example.workout.database.data.ExerciseDatabase
import com.example.workout.database.repository.ExerciseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExerciseViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Exercise>>

    //Filter Exercises by Weekday
    val readMondayData: LiveData<List<Exercise>>
    val readTuesdayData: LiveData<List<Exercise>>
    val readWednesdayData: LiveData<List<Exercise>>
    val readThursdayData: LiveData<List<Exercise>>
    val readFridayData: LiveData<List<Exercise>>
    val readSaturdayData: LiveData<List<Exercise>>
    val readSundayData: LiveData<List<Exercise>>



    private val repository: ExerciseRepository

    init {
        val exerciseDao = ExerciseDatabase.getDatabase(application).exerciseDao()
        repository = ExerciseRepository(exerciseDao)

        readAllData = repository.readAllData

        //Filter Exercises by Weekday
        readMondayData = repository.readMondayData
        readTuesdayData = repository.readTuesdayData
        readWednesdayData = repository.readWednesdayData
        readThursdayData = repository.readThursdayData
        readFridayData = repository.readFridayData
        readSaturdayData = repository.readSaturdayData
        readSundayData = repository.readSundayData

    }

    fun addExercise(exercise: Exercise) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addExercise(exercise)
        }
    }


    fun updateExercise(exercise: Exercise) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateExercise(exercise)
        }
    }

    fun deleteExercise(exercise: Exercise) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteExercise(exercise)
        }
    }

    fun deleteAllExercise() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllExercise()
        }
    }




    // Get Exercise and Weekday Cross Reference



}

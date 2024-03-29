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



    private val repository: ExerciseRepository

    init {
        val exerciseDao = ExerciseDatabase.getDatabase(application).exerciseDao()
        repository = ExerciseRepository(exerciseDao)

        readAllData = repository.readAllData


    }

    fun addExercise(exercise: Exercise) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addExercise(exercise)
        }
    }

    fun deleteAllExercise() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllExercise()
        }
    }


}

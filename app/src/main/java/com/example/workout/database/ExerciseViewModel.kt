package com.example.workout.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.workout.database.data.Exercise
import com.example.workout.database.data.ExerciseDatabase
import com.example.workout.database.data.ExerciseWeekdayCrossRef
import com.example.workout.database.data.Weekday
import com.example.workout.database.data.databases.ExerciseWithWeekday
import com.example.workout.database.data.databases.WeekdayWIthExercise
import com.example.workout.database.repository.ExerciseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExerciseViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Exercise>>
    //val readExerciseWithWeekday: LiveData<List<ExerciseWithWeekday>>
    val readWeekdayWIthExercise: LiveData<List<WeekdayWIthExercise>>
    val readWeekdayWIthExercise2: LiveData<List<WeekdayWIthExercise>>
    val readWeekdayWIthExercise3: LiveData<List<WeekdayWIthExercise>>

    val getExerciseWeekdayCrossMon: LiveData<List<ExerciseWeekdayCrossRef>>
    val getExerciseWeekdayCrossTue: LiveData<List<ExerciseWeekdayCrossRef>>
    val getExerciseWeekdayCrossWed: LiveData<List<ExerciseWeekdayCrossRef>>
    val getExerciseWeekdayCrossThu: LiveData<List<ExerciseWeekdayCrossRef>>
    val getExerciseWeekdayCrossFri: LiveData<List<ExerciseWeekdayCrossRef>>
    val getExerciseWeekdayCrossSat: LiveData<List<ExerciseWeekdayCrossRef>>
    val getExerciseWeekdayCrossSun: LiveData<List<ExerciseWeekdayCrossRef>>



    private val repository: ExerciseRepository

    init {
        val exerciseDao = ExerciseDatabase.getDatabase(application).exerciseDao()
        val weekdayDao = ExerciseDatabase.getDatabase(application).weekdayDao()
        val exerciseWeekdayCrossRefDao =
            ExerciseDatabase.getDatabase(application).exerciseWeekdayCrossRefDao()
        repository = ExerciseRepository(exerciseDao, weekdayDao, exerciseWeekdayCrossRefDao)

        readAllData = repository.readAllData
        //readExerciseWithWeekday = repository.readExerciseWithWeekday
        readWeekdayWIthExercise = repository.readWeekdayWithExercise
        readWeekdayWIthExercise2 = repository.readWeekdayWithExercise2
        readWeekdayWIthExercise3 = repository.readWeekdayWithExercise3

        getExerciseWeekdayCrossMon = repository.getExerciseWeekdayCrossMon
        getExerciseWeekdayCrossTue = repository.getExerciseWeekdayCrossTue
        getExerciseWeekdayCrossWed = repository.getExerciseWeekdayCrossWed
        getExerciseWeekdayCrossThu = repository.getExerciseWeekdayCrossThu
        getExerciseWeekdayCrossFri = repository.getExerciseWeekdayCrossFri
        getExerciseWeekdayCrossSat = repository.getExerciseWeekdayCrossSat
        getExerciseWeekdayCrossSun = repository.getExerciseWeekdayCrossSun
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


    // Weekday and Workout Database
    fun addWeekday(weekday: Weekday) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addWeekday(weekday)
        }
    }

    fun addCrossRef(exerciseWeekdayCrossRef: ExerciseWeekdayCrossRef) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCrossRef(exerciseWeekdayCrossRef)
        }
    }

    // Get Exercise and Weekday Cross Reference



}

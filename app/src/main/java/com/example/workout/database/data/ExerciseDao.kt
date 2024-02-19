package com.example.workout.database.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.workout.database.data.databases.ExerciseWithWeekday
import com.example.workout.database.data.databases.WeekdayWIthExercise

@Dao
interface ExerciseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExercise(exercise: Exercise)

    @Update
    suspend fun updateExercise(exercise: Exercise)

    @Delete
    suspend fun deleteExercise(exercise: Exercise)


    @Query("DELETE FROM workout_table")
    suspend fun deleteAllExercise()

    @Query("SELECT * FROM workout_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Exercise>>

    @Transaction
    @Query("SELECT * FROM workout_table CROSS JOIN weekday_table WHERE weekdayId = 2")
    fun readExerciseWithWeekday(): LiveData<List<ExerciseWithWeekday>>
}

@Dao
interface WeekdayDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addWeekday(weekday: Weekday)

    @Query("SELECT * FROM weekday_table ")
    fun getWeekdayByExercise(): LiveData<List<WeekdayWIthExercise>>

    @Transaction
    @Query("SELECT * FROM weekday_table INNER JOIN workout_table WHERE weekdayId = 1")
    fun readWeekdayWithExercise(): LiveData<List<WeekdayWIthExercise>>

    @Transaction
    @Query("SELECT * FROM weekday_table INNER JOIN workout_table WHERE weekdayId = 2")
    fun readWeekdayWithExercise2(): LiveData<List<WeekdayWIthExercise>>

    @Transaction
    @Query("SELECT * FROM weekday_table INNER JOIN workout_table WHERE weekdayId = 3")
    fun readWeekdayWithExercise3(): LiveData<List<WeekdayWIthExercise>>


}

@Dao
interface ExerciseWeekdayCrossRefDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCrossRef(exerciseWeekdayCrossRef: ExerciseWeekdayCrossRef)

    @Transaction
    @Query("SELECT * FROM exercise_weekday_cross WHERE weekdayId = 1")
    fun getExerciseWeekdayCrossMon(): LiveData<List<ExerciseWeekdayCrossRef>>

    @Transaction
    @Query("SELECT * FROM exercise_weekday_cross WHERE weekdayId = 2")
    fun getExerciseWeekdayCrossTue(): LiveData<List<ExerciseWeekdayCrossRef>>

    @Transaction
    @Query("SELECT * FROM exercise_weekday_cross WHERE weekdayId = 3")
    fun getExerciseWeekdayCrossWed(): LiveData<List<ExerciseWeekdayCrossRef>>

    @Transaction
    @Query("SELECT * FROM exercise_weekday_cross WHERE weekdayId = 4")
    fun getExerciseWeekdayCrossThu(): LiveData<List<ExerciseWeekdayCrossRef>>

    @Transaction
    @Query("SELECT * FROM exercise_weekday_cross WHERE weekdayId = 5")
    fun getExerciseWeekdayCrossFri(): LiveData<List<ExerciseWeekdayCrossRef>>

    @Transaction
    @Query("SELECT * FROM exercise_weekday_cross WHERE weekdayId = 6")
    fun getExerciseWeekdayCrossSat(): LiveData<List<ExerciseWeekdayCrossRef>>

    @Transaction
    @Query("SELECT * FROM exercise_weekday_cross WHERE weekdayId = 7")
    fun getExerciseWeekdayCrossSun(): LiveData<List<ExerciseWeekdayCrossRef>>
}
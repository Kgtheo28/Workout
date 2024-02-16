package com.example.workout.database.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [
        Exercise::class,
        Weekday::class,
        ExerciseWeekdayCrossRef::class], version = 1, exportSchema = false)
abstract class ExerciseDatabase: RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao
    abstract fun weekdayDao(): WeekdayDao
    abstract fun exerciseWeekdayCrossRefDao(): ExerciseWeekdayCrossRefDao

    companion object {
        @Volatile
        private var INSTANCE: ExerciseDatabase? = null

        fun getDatabase(context: Context): ExerciseDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExerciseDatabase::class.java,
                    "exercise_database"
                ).build()
                INSTANCE= instance
                return instance
            }
        }
    }
}
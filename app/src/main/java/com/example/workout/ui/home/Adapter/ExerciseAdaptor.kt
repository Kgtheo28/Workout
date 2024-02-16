package com.example.workout.ui.home.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workout.R
import com.example.workout.database.data.Exercise
import com.example.workout.database.data.ExerciseWeekdayCrossRef
import com.example.workout.database.data.databases.ExerciseWithWeekday
import com.example.workout.database.data.databases.WeekdayWIthExercise

// ExerciseAdapter.kt
class ExerciseAdapter: RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

    private var exerciseList = emptyList<WeekdayWIthExercise>()

    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        return ExerciseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val currentItem = exerciseList[position]
        /*
        holder.itemView.findViewById<TextView>(R.id.tv_body_part).text = currentItem.exercise.bodyPart
        holder.itemView.findViewById<TextView>(R.id.tv_exercise_name).text = currentItem.exercise.exerciseName
        holder.itemView.findViewById<TextView>(R.id.tv_id).text = currentItem.exercise.id.toString()

         */

        holder.itemView.findViewById<TextView>(R.id.tv_body_part).text = currentItem.weekday.weekdayName
        holder.itemView.findViewById<TextView>(R.id.tv_id).text = currentItem.weekday.weekdayId.toString()
    }

    override fun getItemCount() = exerciseList.size

    fun setData(exercise: List<WeekdayWIthExercise>){
        this.exerciseList = exercise
        notifyDataSetChanged()
    }
}

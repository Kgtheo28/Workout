package com.example.workout.ui.notifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workout.R
import com.example.workout.database.data.Exercise
import com.example.workout.database.data.databases.WeekdayWIthExercise

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<Exercise>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.findViewById<TextView>(R.id.tv_equipment).text = currentItem.bodyPart
        holder.itemView.findViewById<TextView>(R.id.tv_exercise_name).text = currentItem.exerciseName
        holder.itemView.findViewById<TextView>(R.id.tv_id).text = currentItem.id.toString()
    }

    fun setData(exercise: List<Exercise>){
        this.userList = exercise
        notifyDataSetChanged()
    }
}
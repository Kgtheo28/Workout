package com.example.workout.ui.calender

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workout.R
import com.example.workout.database.data.Exercise
import com.example.workout.ui.notifications.ListAdapter

class HomeCalenderAdaptor: RecyclerView.Adapter<HomeCalenderAdaptor.MyViewHolder>() {

    private var userList = emptyList<Exercise>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return HomeCalenderAdaptor.MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.calender_card_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.findViewById<TextView>(R.id.schedule_body_part).text = currentItem.bodyPart
    }

    fun setData(exercise: List<Exercise>){
        this.userList = exercise
        notifyDataSetChanged()
    }
}
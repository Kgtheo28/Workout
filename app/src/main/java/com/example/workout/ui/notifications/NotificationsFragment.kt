package com.example.workout.ui.notifications

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workout.database.ExerciseViewModel
import com.example.workout.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var mUserViewModel: ExerciseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //val notificationsViewModel =
        //    ViewModelProvider(this).get(NotificationsViewModel::class.java)
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView: TextView = binding.textNotifications
        //notificationsViewModel.text.observe(viewLifecycleOwner) {
        //    textView.text = it
        //}

        //RecyclerView
        val adapter = ListAdapter()
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //mUserViewModel
        mUserViewModel = ViewModelProvider(this).get(ExerciseViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { exercise ->
            adapter.setData(exercise)
        })

        binding.button.setOnClickListener {
            deleteAllUser()
        }




        return root
    }

    private fun deleteAllUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){ _, _ ->
            mUserViewModel.deleteAllExercise()
            Toast.makeText(requireContext(), "Successfully deleted all data",
                Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") {
                _, _ ->

        }
        builder.setTitle("Delete all data ?")
        builder.create().show()
    }
}
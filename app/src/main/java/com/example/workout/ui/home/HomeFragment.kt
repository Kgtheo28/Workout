package com.example.workout.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workout.R
import com.example.workout.database.ExerciseViewModel
import com.example.workout.databinding.FragmentHomeBinding
import com.example.workout.ui.home.Adapter.ExerciseAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var mUserViewModel: ExerciseViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // remove val root input setcontentview

        binding.weeklyCalender.setOnClickListener {
            //val customDialog = CustomMultiSelectionDialog(context)
            //customDialog.show()
            //findNavController().navigate(R.id.action_navigation_home_to_customMultiSelectionDialog)
            val intent = Intent(requireContext(), CustomMultiSelectionDialog::class.java)
            startActivity(intent)
        }

        binding.tvMonthYear.setOnClickListener {
            //toggleRecyclerViewVisibility()
        }


        binding.mondayBtn.setOnClickListener {
            val adapter = ExerciseAdapter()
            val recyclerView = binding.calenderRecyclerView
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())

            //mUserViewModel
            mUserViewModel = ViewModelProvider(this).get(ExerciseViewModel::class.java)
            mUserViewModel.getExerciseWeekdayCrossMon.observe(viewLifecycleOwner, Observer { exerciseWeekdayCrossRef ->
                adapter.setData(exerciseWeekdayCrossRef)
            })
            toggleRecyclerViewVisibility()
        }

        binding.tuesdayBtn.setOnClickListener {
            val adapter = ExerciseAdapter()
            val recyclerView = binding.calenderRecyclerView
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())

            //mUserViewModel
            mUserViewModel = ViewModelProvider(this).get(ExerciseViewModel::class.java)
            mUserViewModel.getExerciseWeekdayCrossTue.observe(viewLifecycleOwner, Observer { exerciseWeekdayCrossRef ->
                adapter.setData(exerciseWeekdayCrossRef)
            })
            toggleRecyclerViewVisibility()
        }

        binding.wednesdayBtn.setOnClickListener {
            val adapter = ExerciseAdapter()
            val recyclerView = binding.calenderRecyclerView
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())

            //mUserViewModel
            mUserViewModel = ViewModelProvider(this).get(ExerciseViewModel::class.java)
            mUserViewModel.getExerciseWeekdayCrossWed.observe(viewLifecycleOwner, Observer { exerciseWeekdayCrossRef ->
                adapter.setData(exerciseWeekdayCrossRef)
            })
            toggleRecyclerViewVisibility()
        }

        binding.thursdayBtn.setOnClickListener {
            val adapter = ExerciseAdapter()
            val recyclerView = binding.calenderRecyclerView
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())

            //mUserViewModel
            mUserViewModel = ViewModelProvider(this).get(ExerciseViewModel::class.java)
            mUserViewModel.getExerciseWeekdayCrossThu.observe(viewLifecycleOwner, Observer { exerciseWeekdayCrossRef ->
                adapter.setData(exerciseWeekdayCrossRef)
            })
            toggleRecyclerViewVisibility()
        }

        binding.fridayBtn.setOnClickListener {
            val adapter = ExerciseAdapter()
            val recyclerView = binding.calenderRecyclerView
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())

            //mUserViewModel
            mUserViewModel = ViewModelProvider(this).get(ExerciseViewModel::class.java)
            mUserViewModel.getExerciseWeekdayCrossFri.observe(viewLifecycleOwner, Observer { exerciseWeekdayCrossRef ->
                adapter.setData(exerciseWeekdayCrossRef)
            })
            toggleRecyclerViewVisibility()
        }

        binding.saturdayBtn.setOnClickListener {
            val adapter = ExerciseAdapter()
            val recyclerView = binding.calenderRecyclerView
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())

            //mUserViewModel
            mUserViewModel = ViewModelProvider(this).get(ExerciseViewModel::class.java)
            mUserViewModel.getExerciseWeekdayCrossSat.observe(viewLifecycleOwner, Observer { exerciseWeekdayCrossRef ->
                adapter.setData(exerciseWeekdayCrossRef)
            })
            toggleRecyclerViewVisibility()
        }

        binding.sundayBtn.setOnClickListener {
            val adapter = ExerciseAdapter()
            val recyclerView = binding.calenderRecyclerView
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())

            //mUserViewModel
            mUserViewModel = ViewModelProvider(this).get(ExerciseViewModel::class.java)
            mUserViewModel.getExerciseWeekdayCrossSun.observe(viewLifecycleOwner, Observer { exerciseWeekdayCrossRef ->
                adapter.setData(exerciseWeekdayCrossRef)
            })
            toggleRecyclerViewVisibility()
        }

        binding.workoutMenId.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard)
        }
        return root
    }

    private fun toggleRecyclerViewVisibility() {

        val nestedRecyclerView = binding.nestedRecyclerView

        if(nestedRecyclerView.visibility == View.VISIBLE){
            nestedRecyclerView.visibility = View.GONE
        }else {
            nestedRecyclerView.visibility = View.VISIBLE
        }
    }


}
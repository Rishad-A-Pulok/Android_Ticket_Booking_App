package com.example.action_input_class07

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.action_input_class07.databinding.FragmentScheduleListBinding

class ScheduleListFragment : Fragment() {
    private lateinit var binding: FragmentScheduleListBinding
    // private lateinit var viewModel: ScheduleViewModel
    private val vm: ScheduleViewModel by activityViewModels()  // when data passes in multiple activity then use activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //viewModel = ViewModelProvider(this).get(ScheduleViewModel::class.java)
        binding = FragmentScheduleListBinding.inflate(inflater,container,false)
        val adapter = ScheduleAdapter()
        binding.scheduleRV.layoutManager = LinearLayoutManager(activity)
        binding.scheduleRV.adapter = adapter
        adapter.submitList(vm.getSchedule())
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_scheduleListFragment_to_newScheduleFragment)
        }
        return binding.root
    }
}
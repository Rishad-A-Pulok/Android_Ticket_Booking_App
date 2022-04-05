package com.example.action_input_class07

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.view.SupportActionModeWrapper
import androidx.navigation.fragment.findNavController
import com.example.action_input_class07.customdiaglogs.DatePickerFragment
import com.example.action_input_class07.customdiaglogs.TimePickerFragment
import com.example.action_input_class07.databinding.FragmentNewScheduleBinding

class NewScheduleFragment : Fragment() {
    private lateinit var binding: FragmentNewScheduleBinding
    private var from = "Dhaka"
    private var to = "Dhaka"
    private var busType = busTypeEconomy

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewScheduleBinding.inflate(inflater,container,false)
        initSpinners()
        initBusTypeRG()
        binding.dateBtn.setOnClickListener {
            DatePickerFragment{
                binding.showDateTV.text = it
            }.show(childFragmentManager,null)
        }
        binding.timeBtn.setOnClickListener {
            TimePickerFragment{
                binding.showTimeTV.text = it
            }.show(childFragmentManager,null)

        }
        binding.saveBtn.setOnClickListener {
            saveInfo()
        }
        return binding.root
    }

    private fun saveInfo() {
        val name = binding.busNameET.text.toString()
        val date = binding.showDateTV.text.toString()
        val time = binding.showTimeTV.text.toString()
        //TODO: validate this info
        if(from == to){
            Toast.makeText(requireActivity(), "Starting and Destination can not be same!", Toast.LENGTH_SHORT).show()
            return
        }
        val schedule = BusSchedule(
            id = System.currentTimeMillis(),
            busName = name,
            busType = busType,
            departureDate = date,
            departureTime = time,
            fromCity = from,
            toCity = to
        )
        scheduleList.add(schedule)
        //findNavController().popBackStack() // to pop the current fragments
        findNavController().navigate(R.id.action_newScheduleFragment_to_scheduleListFragment)
        Log.d("NewScheduleFragment","saveInfo: $schedule")
    }

    private fun initBusTypeRG() {
        binding.busTypeRG.setOnCheckedChangeListener { radioGroup, i ->
            val rb: RadioButton = radioGroup.findViewById(i)
            busType = rb.text.toString()
        }
    }

    private fun initSpinners() {
        val adapter = ArrayAdapter<String>(
            requireActivity(),
            android.R.layout.simple_spinner_dropdown_item,
            cityList
        )
        binding.fromCitySpinner.adapter = adapter
        binding.toCitySpinner.adapter = adapter

        binding.fromCitySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                from = p0?.getItemAtPosition(p2).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        binding.toCitySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                to = p0?.getItemAtPosition(p2).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

    }
}
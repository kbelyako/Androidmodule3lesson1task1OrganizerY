package com.example.androidmodule3lesson1task1organizery

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

private lateinit var mTaskViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_add, container, false)
       mTaskViewModel=ViewModelProvider(this).get(TaskViewModel::class.java)

       view.bt_add_button.setOnClickListener{
        insertDataToDB()
    }

    return view
    }

    private fun insertDataToDB() {
        val title=et_TaskTitle.text.toString()
        val description=et_TaskDesc.text.toString()
        val time=et_TaskTime.text.toString()

        val task2=OrganizerTask(0,"go to shop","buy yogurt")

        if(inputCheck(title,description,time)){
            val task=OrganizerTask(0,title,description)
            mTaskViewModel.addTask(task)
            Toast.makeText(requireContext(),"Successfully added!",Toast.LENGTH_LONG)
        }
    }

    private fun inputCheck(title: String, description: String, time: String): Boolean {
        return !(TextUtils.isEmpty(time)&&TextUtils.isEmpty(description)&&time.isEmpty())

    }


}
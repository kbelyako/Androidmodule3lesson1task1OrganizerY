package com.example.androidmodule3lesson1task1organizery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmodule3lesson1task1organizery.OrganizerTask
import com.example.androidmodule3lesson1task1organizery.R
import kotlinx.android.synthetic.main.single_task.view.*

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var tasksList= emptyList<OrganizerTask>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.single_task,parent,false))
    }

    override fun getItemCount(): Int {
        return tasksList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=tasksList[position]
        holder.itemView.tv_TaskTitle.text=currentItem.title
        holder.itemView.tvTaskDescription.text=currentItem.description
    }

    fun setData(task: List<OrganizerTask>) {
        this.tasksList=task
        notifyDataSetChanged()
    }



}
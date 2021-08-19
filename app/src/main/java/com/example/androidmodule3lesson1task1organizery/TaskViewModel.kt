package com.example.androidmodule3lesson1task1organizery

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application):AndroidViewModel(application) {

 val readAllData:LiveData<List<OrganizerTask>>
private val repository:TaskRepository
    init {

        val tasksDao=AppDatabase.getDB(application).organizerTaskDao()
      //  val dbThread:DataBaseThread=DataBaseThread()
      //  dbThread.taskDao


    //    repository=TaskRepository(dbThread.taskDao!!)
        repository=TaskRepository(tasksDao)
        readAllData=repository.readAllData

    }

    fun addTask(organizerTask: OrganizerTask) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.addTask(organizerTask)
        }
    }
/*
        fun getDB(organizerTask: OrganizerTask):OrganizerTask {
        viewModelScope.launch (Dispatchers.IO) {
            val tasksDao: OrganizerTaskDao=AppDatabase.getDB(application).organizerTaskDao()
        }
        return tasksDao
    }
 */

}
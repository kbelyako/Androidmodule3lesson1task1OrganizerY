package com.example.androidmodule3lesson1task1organizery

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface OrganizerTaskDao {

    @Query("SELECT * FROM tasks_table")
    fun getAll():  LiveData<List<OrganizerTask>>

    @Query("SELECT * FROM tasks_table WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<OrganizerTask>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(organizerTask: OrganizerTask)

    @Update
    fun update(organizerTask: OrganizerTask)

    @Delete
    fun delete(organizerTask: OrganizerTask)

    @Query("DELETE FROM tasks_table")
     fun clear()
}
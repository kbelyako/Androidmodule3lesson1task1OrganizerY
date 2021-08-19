package com.example.androidmodule3lesson1task1organizery

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="tasks_table")
data class OrganizerTask (

    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    @ColumnInfo(name = "subject") val title: String?,
    @ColumnInfo(name = "description") val description: String?
    //  @ColumnInfo(name = "time") val time: String?


)


package com.example.androidmodule3lesson1task1organizery

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(OrganizerTask::class), version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun organizerTaskDao(): OrganizerTaskDao


    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? =null

        fun getDB(context: Context):AppDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance=Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "tasks_db")
                .fallbackToDestructiveMigration()
                .build()
                INSTANCE=instance
                return instance
            }
        }
    }
}
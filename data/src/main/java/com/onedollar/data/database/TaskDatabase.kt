package com.onedollar.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.onedollar.data.dao.TaskDao
import com.onedollar.data.entity.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {
        private lateinit var INSTANCE: TaskDatabase

        @Synchronized
        fun getDatabase(context: Context): TaskDatabase {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = buildDatabase(context.applicationContext)
            }
            return INSTANCE
        }

        private fun buildDatabase(context: Context): TaskDatabase {
            return Room.databaseBuilder(context, TaskDatabase::class.java, "task_database")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
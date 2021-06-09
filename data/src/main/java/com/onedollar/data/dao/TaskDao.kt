package com.onedollar.data.dao

import androidx.room.*
import com.onedollar.data.entity.TaskEntity

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    suspend fun getTaskList(): List<TaskEntity>

    @Insert
    suspend fun insertTask(taskEntity: TaskEntity)

    @Update
    suspend fun updateTask(taskEntity: TaskEntity)

    @Delete
    suspend fun deleteTask(taskEntity: TaskEntity)
}
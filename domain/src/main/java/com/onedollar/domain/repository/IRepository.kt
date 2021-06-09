package com.onedollar.domain.repository

import com.onedollar.domain.model.TaskModel

interface IRepository {

    suspend fun getTaskList(): List<TaskModel>
    suspend fun insertTask(task: TaskModel)
    suspend fun updateTask(task: TaskModel)
    suspend fun deleteTask(task: TaskModel)
}
package com.onedollar.data.repository

import com.onedollar.data.database.TaskDatabase
import com.onedollar.data.mapper.TaskEntityMapper
import com.onedollar.data.mapper.TaskModelMapper
import com.onedollar.domain.model.TaskModel
import com.onedollar.domain.repository.IRepository

class TaskRepository(private val taskDatabase: TaskDatabase) : IRepository {
    private val taskEntityMapper = TaskEntityMapper()
    private val taskModelMapper = TaskModelMapper()

    override suspend fun getTaskList(): List<TaskModel> {
        return taskDatabase.taskDao().getTaskList().map { taskEntityMapper.map(it) }
    }

    override suspend fun insertTask(task: TaskModel) {
        return taskDatabase.taskDao().insertTask(taskModelMapper.map(task))
    }

    override suspend fun updateTask(task: TaskModel) {
        return taskDatabase.taskDao().updateTask(taskModelMapper.map(task))
    }

    override suspend fun deleteTask(task: TaskModel) {
        return taskDatabase.taskDao().deleteTask(taskModelMapper.map(task))
    }
}
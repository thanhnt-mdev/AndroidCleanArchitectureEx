package com.onedollar.domain.usecase

import com.onedollar.domain.model.TaskModel
import com.onedollar.domain.repository.IRepository

class DeleteTaskUseCase(private val repository: IRepository) {
    suspend fun execute(task: TaskModel) {
        return repository.deleteTask(task)
    }
}
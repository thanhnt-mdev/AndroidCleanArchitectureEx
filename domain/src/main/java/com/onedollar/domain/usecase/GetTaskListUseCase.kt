package com.onedollar.domain.usecase

import com.onedollar.domain.model.TaskModel
import com.onedollar.domain.repository.IRepository

class GetTaskListUseCase(private val repository: IRepository) {
    suspend fun execute(): List<TaskModel> {
        return repository.getTaskList()
    }
}
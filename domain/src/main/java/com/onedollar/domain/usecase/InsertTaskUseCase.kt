package com.onedollar.domain.usecase

import com.onedollar.domain.model.TaskModel
import com.onedollar.domain.repository.IRepository

class InsertTaskUseCase(private val repository: IRepository) {
    suspend fun execute(task: TaskModel) {
        return repository.insertTask(task)
    }
}
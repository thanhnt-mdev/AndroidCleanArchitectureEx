package com.onedollar.data.mapper

import com.onedollar.data.entity.TaskEntity
import com.onedollar.domain.model.TaskModel
import com.onedollar.domain.model.TaskStatus

class TaskEntityMapper : Mapper<TaskEntity, TaskModel> {
    override fun map(t: TaskEntity): TaskModel {
        return TaskModel(
            t.id,
            t.title,
            t.description,
            t.dueDate,
            getTaskStatus(t.taskStatus)
        )
    }

    private fun getTaskStatus(taskStatus: Int): TaskStatus {
        return when (taskStatus) {
            0 -> TaskStatus.NEW
            1 -> TaskStatus.IN_PROGRESS
            2 -> TaskStatus.IN_REVIEW
            3 -> TaskStatus.COMPLETE
            4 -> TaskStatus.CANCELLED
            else -> TaskStatus.NEW
        }
    }
}
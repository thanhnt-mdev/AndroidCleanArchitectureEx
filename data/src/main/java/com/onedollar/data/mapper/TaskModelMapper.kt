package com.onedollar.data.mapper

import com.onedollar.data.entity.TaskEntity
import com.onedollar.domain.model.TaskModel

class TaskModelMapper : Mapper<TaskModel, TaskEntity> {
    override fun map(t: TaskModel): TaskEntity {
        return TaskEntity(
            t.id,
            t.title,
            t.description,
            t.dueDate,
            t.taskStatus.ordinal
        )
    }
}
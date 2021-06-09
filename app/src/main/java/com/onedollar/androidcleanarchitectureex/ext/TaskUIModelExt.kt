package com.onedollar.androidcleanarchitectureex.ext

import com.onedollar.androidcleanarchitectureex.model.TaskUIModel
import com.onedollar.domain.model.TaskModel

fun TaskUIModel.toDomainModel() = TaskModel(
    id,
    title,
    description,
    dueDate,
    taskStatus
)
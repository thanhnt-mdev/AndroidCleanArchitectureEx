package com.onedollar.androidcleanarchitectureex.ext

import com.onedollar.androidcleanarchitectureex.model.TaskUIModel
import com.onedollar.domain.model.TaskModel

fun TaskModel.toUIModel() = TaskUIModel(
    id,
    title,
    description,
    dueDate,
    taskStatus
)
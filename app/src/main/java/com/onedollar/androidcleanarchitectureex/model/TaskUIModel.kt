package com.onedollar.androidcleanarchitectureex.model

import com.onedollar.domain.model.TaskStatus
import java.io.Serializable

data class TaskUIModel(
    val id: Int,
    val title: String,
    val description: String?,
    val dueDate: Long,
    val taskStatus: TaskStatus
) : Serializable
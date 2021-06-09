package com.onedollar.domain.model

data class TaskModel(
    val id: Int,
    val title: String,
    val description: String?,
    val dueDate: Long,
    val taskStatus: TaskStatus
)
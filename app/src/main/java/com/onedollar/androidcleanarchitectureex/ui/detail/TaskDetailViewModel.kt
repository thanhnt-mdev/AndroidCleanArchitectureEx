package com.onedollar.androidcleanarchitectureex.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onedollar.androidcleanarchitectureex.ext.toDomainModel
import com.onedollar.androidcleanarchitectureex.model.TaskUIModel
import com.onedollar.domain.usecase.DeleteTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskDetailViewModel @Inject constructor(private val useCase: DeleteTaskUseCase) :
    ViewModel() {

    private val _currentTask = MutableLiveData<TaskUIModel>()
    val currentTask: LiveData<TaskUIModel>
        get() = _currentTask

    fun delete(taskModel: TaskUIModel) {
        viewModelScope.launch {
            useCase.execute(taskModel.toDomainModel())
        }
    }

    fun setTask(taskModel: TaskUIModel) {
        _currentTask.value = taskModel
    }
}
package com.onedollar.androidcleanarchitectureex.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onedollar.androidcleanarchitectureex.ext.toUIModel
import com.onedollar.androidcleanarchitectureex.model.TaskUIModel
import com.onedollar.domain.usecase.GetTaskListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(private val getTaskListUseCase: GetTaskListUseCase) :
    ViewModel() {

    private val _taskList = MutableLiveData<List<TaskUIModel>>()
    val taskList: LiveData<List<TaskUIModel>>
        get() = _taskList

    init {
        loadTaskList()
    }

    private fun loadTaskList() {
        viewModelScope.launch(Dispatchers.IO) {
            val taskList = getTaskListUseCase.execute().map { it.toUIModel() }
            _taskList.postValue(taskList)
        }
    }
}
package com.onedollar.androidcleanarchitectureex.ui.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onedollar.androidcleanarchitectureex.ext.toDomainModel
import com.onedollar.androidcleanarchitectureex.model.TaskUIModel
import com.onedollar.domain.usecase.InsertTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateTaskViewModel @Inject constructor(private val useCase: InsertTaskUseCase) : ViewModel() {

    fun insert(taskModel: TaskUIModel) {
        viewModelScope.launch {
            useCase.execute(taskModel.toDomainModel())
        }
    }
}
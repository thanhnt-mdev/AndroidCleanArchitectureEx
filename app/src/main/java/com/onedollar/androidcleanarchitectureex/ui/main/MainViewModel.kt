package com.onedollar.androidcleanarchitectureex.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onedollar.androidcleanarchitectureex.model.TaskUIModel

class MainViewModel : ViewModel() {

    private val _currentView = MutableLiveData(0)
    val currentView: LiveData<Int>
        get() = _currentView

    var currentTask: TaskUIModel? = null

    fun setCurrentView(view: Int) {
        _currentView.value = view
    }
}
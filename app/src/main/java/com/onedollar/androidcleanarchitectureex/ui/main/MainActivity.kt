package com.onedollar.androidcleanarchitectureex.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.onedollar.androidcleanarchitectureex.R
import com.onedollar.androidcleanarchitectureex.model.TaskUIModel
import com.onedollar.androidcleanarchitectureex.ui.create.CreateTaskFragment
import com.onedollar.androidcleanarchitectureex.ui.detail.TaskDetailFragment
import com.onedollar.androidcleanarchitectureex.ui.list.TaskListFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), TaskListFragment.Listener {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCreate.setOnClickListener { navigateToCreate() }

        viewModel.currentView.observe(this) { view ->
            updateView(view)
        }
    }

    private fun updateView(view: Int) {
        val fragment = when (view) {
            0 -> TaskListFragment().apply {
                listener = this@MainActivity
            }
            1 -> CreateTaskFragment()
            2 -> TaskDetailFragment()
            else -> throw IllegalStateException("No fragment for view $view")
        }

        if (view == 2) {
            fragment.arguments = Bundle().apply {
                putSerializable(TaskDetailFragment.EXTRA_TASK, viewModel.currentTask)
            }
        }

        val addToBackStack = when (view) {
            0 -> false
            else -> true
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment, "tag_$view")
            .also {
                if (addToBackStack) {
                    it.addToBackStack(null)
                }
            }
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            navigateToList()
        } else {
            super.onBackPressed()
        }
    }

    private fun navigateToCreate() {
        viewModel.setCurrentView(1)
    }

    private fun navigateToList() {
        viewModel.setCurrentView(0)
    }

    override fun navigateToDetail(task: TaskUIModel) {
        viewModel.currentTask = task
        viewModel.setCurrentView(2)
    }
}
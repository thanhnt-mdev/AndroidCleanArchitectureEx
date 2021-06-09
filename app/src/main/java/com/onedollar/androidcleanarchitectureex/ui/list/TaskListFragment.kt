package com.onedollar.androidcleanarchitectureex.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.onedollar.androidcleanarchitectureex.R
import com.onedollar.androidcleanarchitectureex.model.TaskUIModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_task_list.*

@AndroidEntryPoint
class TaskListFragment : Fragment() {
    companion object {
        private const val TAG = "TaskListFragment"
    }

    private val viewModel: TaskListViewModel by viewModels()
    private val adapter = TaskListAdapter()

    var listener: Listener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.listener = object : TaskListAdapter.Listener {
            override fun onItemClick(position: Int, item: TaskUIModel) {
                listener?.navigateToDetail(item)
            }
        }
        rvTaskList.adapter = adapter

        viewModel.taskList.observe(viewLifecycleOwner) { taskList ->
            Log.d(TAG, "onViewCreated: task list changed $taskList")
            adapter.submitList(taskList)
        }
    }

    interface Listener {
        fun navigateToDetail(task: TaskUIModel)
    }
}
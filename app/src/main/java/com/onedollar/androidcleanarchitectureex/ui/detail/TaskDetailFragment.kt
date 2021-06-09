package com.onedollar.androidcleanarchitectureex.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.onedollar.androidcleanarchitectureex.R
import com.onedollar.androidcleanarchitectureex.model.TaskUIModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_task_detail.*

@AndroidEntryPoint
class TaskDetailFragment : Fragment() {

    companion object {
        const val EXTRA_TASK = "task"
    }

    private val viewModel: TaskDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val task = arguments?.getSerializable(EXTRA_TASK) as TaskUIModel?
        task?.let { viewModel.setTask(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnDelete.setOnClickListener { deleteTask() }

        viewModel.currentTask.observe(viewLifecycleOwner) { task ->
            bind(task)
        }
    }

    private fun bind(task: TaskUIModel?) {
        btnDelete.isEnabled = task != null
        if (task == null) {
            return
        }

        tvName.text = task.title
        tvDescription.text = task.description
    }

    private fun deleteTask() {
        viewModel.delete(viewModel.currentTask.value!!)
    }
}
package com.onedollar.androidcleanarchitectureex.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.onedollar.androidcleanarchitectureex.R
import com.onedollar.androidcleanarchitectureex.model.TaskUIModel
import com.onedollar.domain.model.TaskStatus
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_create_task.*

@AndroidEntryPoint
class CreateTaskFragment : Fragment() {
    private val viewModel: CreateTaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_create_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSave.setOnClickListener { saveTask() }
    }

    private fun saveTask() {
        val name: String = etName.text?.toString() ?: ""
        val description: String = etDescription.text?.toString() ?: ""

        if (name.isNullOrEmpty() || description.isNullOrEmpty()) {
            Toast.makeText(
                requireContext(),
                "Name and description are required",
                Toast.LENGTH_SHORT
            ).show()
        }

        viewModel.insert(
            TaskUIModel(
                0,
                name,
                description,
                System.currentTimeMillis(),
                TaskStatus.NEW
            )
        )
    }
}
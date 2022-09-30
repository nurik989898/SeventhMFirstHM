package com.example.seventhmfirsthm.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.seventhmfirsthm.core.BaseFragment
import com.example.seventhmfirsthm.core.UIState
import com.example.seventhmfirsthm.databinding.FragmentAddNoteBinding
import com.example.seventhmfirsthm.domain.model.Note
import com.example.seventhmfirsthm.presentation.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class AddNoteFragment : BaseFragment() {

    private lateinit var binding: FragmentAddNoteBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            if (binding.etTitle.text.isNotEmpty() && binding.etDescription.text.isNotEmpty()) {
                viewModel.addNote(Note(title = binding.etTitle.toString(),
                    description = binding.etDescription.toString()))
                findNavController().navigateUp()
            } else {
                Toast.makeText(requireContext(), "Заполните оба поля", Toast.LENGTH_SHORT).show()
            }
        }
        addNote()
    }

    private fun addNote() {
        viewModel.addNoteState.subscride(
            { error ->
                Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
            },
            {
                // TODO show progress bar
            },
            {
                viewModel.getAllNotes()
            })
    }
}
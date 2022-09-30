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
import com.example.seventhmfirsthm.R
import com.example.seventhmfirsthm.core.BaseFragment
import com.example.seventhmfirsthm.core.UIState
import com.example.seventhmfirsthm.databinding.FragmentNoteBinding
import com.example.seventhmfirsthm.presentation.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NoteFragment : BaseFragment() {

    private lateinit var binding: FragmentNoteBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllNotes()
        getAllNotes()
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.addNoteFragment)
        }
    }

    private fun getAllNotes() {
        viewModel.getAllNotesState.subscride(
            { error ->
                Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
            },
            {
                // TODO show progress bar
            },
            { data ->
                adapter = NoteAdapter(data)
                binding.recyclerview.adapter = adapter
            })
    }
}
package com.example.seventhmfirsthm.presentation.main

import com.example.seventhmfirsthm.core.BaseViewModel
import com.example.seventhmfirsthm.core.UIState
import com.example.seventhmfirsthm.domain.model.Note
import com.example.seventhmfirsthm.domain.use_case.AddNoteUseCase
import com.example.seventhmfirsthm.domain.use_case.DeleteNoteUseCase
import com.example.seventhmfirsthm.domain.use_case.EditNoteUseCase
import com.example.seventhmfirsthm.domain.use_case.GetAllNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase,
    private val getAllNoteUseCase: GetAllNoteUseCase,
) : BaseViewModel() {

    private val _addNoteState = MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val addNoteState = _addNoteState.asStateFlow()

    private val _getAllNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Loading())
    val getAllNotesState = _getAllNotesState.asStateFlow()

    fun addNote(note: Note) {
        addNoteUseCase.addNote(note).getData(
            { error ->
                _addNoteState.value = UIState.Error(error ?: "Unknown message")
            },
            {
                _addNoteState.value = UIState.Loading()
            },
            { data ->
                if (data != null)
                    _addNoteState.value = UIState.Success(data)
            })
    }

    fun getAllNotes() {
        getAllNoteUseCase.getAllNotes().getData(
            { error ->
                _getAllNotesState.value = UIState.Error(error ?: "Unknown message")
            },
            {
                _getAllNotesState.value = UIState.Loading()
            },
            { data ->
                if (data != null)
                    _getAllNotesState.value = UIState.Success(data)
            })
    }
}
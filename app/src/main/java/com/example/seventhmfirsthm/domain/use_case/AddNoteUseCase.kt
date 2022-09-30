package com.example.seventhmfirsthm.domain.use_case

import com.example.seventhmfirsthm.domain.model.Note
import com.example.seventhmfirsthm.domain.repository.NoteRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    fun addNote(note: Note) = noteRepository.addNote(note)
}
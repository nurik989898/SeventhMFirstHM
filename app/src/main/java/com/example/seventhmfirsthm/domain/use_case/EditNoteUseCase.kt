package com.example.seventhmfirsthm.domain.use_case

import com.example.seventhmfirsthm.domain.model.Note
import com.example.seventhmfirsthm.domain.repository.NoteRepository
import javax.inject.Inject

class EditNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    fun editNote(note: Note) = noteRepository.editNote(note)
}
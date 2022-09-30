package com.example.seventhmfirsthm.domain.use_case

import com.example.seventhmfirsthm.domain.model.Note
import com.example.seventhmfirsthm.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    fun deleteNote(note: Note) = noteRepository.deleteNote(note)
}
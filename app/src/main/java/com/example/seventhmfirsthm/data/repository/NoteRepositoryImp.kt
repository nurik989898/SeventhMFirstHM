package com.example.seventhmfirsthm.data.repository

import com.example.seventhmfirsthm.core.BaseRepository
import com.example.seventhmfirsthm.core.Resource
import com.example.seventhmfirsthm.core.noteEntityToNote
import com.example.seventhmfirsthm.data.local.NoteDao
import com.example.seventhmfirsthm.core.noteToNoteEntity
import com.example.seventhmfirsthm.domain.model.Note
import com.example.seventhmfirsthm.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NoteRepositoryImp @Inject constructor(private val noteDao: NoteDao) : NoteRepository,
    BaseRepository() {

    override fun addNote(note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.addNote(note.noteToNoteEntity())
    }

    override fun getAllNotes(): Flow<Resource<List<Note>>> = doRequest {
        noteDao.getAllNotes().map { noteEntity -> noteEntity.noteEntityToNote() }
    }

    override fun editNote(note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.editNote(note.noteToNoteEntity())
    }

    override fun deleteNote(note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.deleteNote(note.noteToNoteEntity())
    }
}
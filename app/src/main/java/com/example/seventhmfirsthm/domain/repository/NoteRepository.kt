package com.example.seventhmfirsthm.domain.repository

import com.example.seventhmfirsthm.core.Resource
import com.example.seventhmfirsthm.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun addNote(note: Note): Flow<Resource<Unit>>

    fun getAllNotes(): Flow<Resource<List<Note>>>

    fun editNote(note: Note): Flow<Resource<Unit>>

    fun deleteNote(note: Note): Flow<Resource<Unit>>

}
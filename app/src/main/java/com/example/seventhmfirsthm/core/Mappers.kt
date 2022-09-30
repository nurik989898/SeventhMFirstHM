package com.example.seventhmfirsthm.core

import com.example.seventhmfirsthm.data.model.NoteEntity
import com.example.seventhmfirsthm.domain.model.Note

fun NoteEntity.noteEntityToNote() =
    Note(id = this.id, title = this.title, description = this.description)

fun Note.noteToNoteEntity() =
    NoteEntity(id = this.id, title = this.title, description = this.description)
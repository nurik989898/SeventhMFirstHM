package com.example.seventhmfirsthm.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String? = null,
    var description: String? = null,
)

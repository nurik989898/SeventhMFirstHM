package com.example.seventhmfirsthm.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.seventhmfirsthm.data.local.NoteDao
import com.example.seventhmfirsthm.data.local.NoteDatabase
import com.example.seventhmfirsthm.data.repository.NoteRepositoryImp
import com.example.seventhmfirsthm.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, NoteDatabase::class.java, "note_db").allowMainThreadQueries()
            .build()

    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase) = noteDatabase.noteDao()

    @Provides
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository {
        return NoteRepositoryImp(noteDao)
    }

}
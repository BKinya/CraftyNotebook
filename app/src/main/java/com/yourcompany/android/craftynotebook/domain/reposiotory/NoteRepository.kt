package com.yourcompany.android.craftynotebook.domain.reposiotory

import com.yourcompany.android.craftynotebook.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes(): Flow<List<Note>>
     fun getDeletedNotes(): Flow<List<Note>>
}
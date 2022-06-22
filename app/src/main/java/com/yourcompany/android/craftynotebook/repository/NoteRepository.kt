package com.yourcompany.android.craftynotebook.repository

import com.yourcompany.android.craftynotebook.data.local.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes(): Flow<List<Note>>
     fun getDeletedNotes(): Flow<List<Note>>
}
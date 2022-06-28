package com.yourcompany.android.craftynotebook.data.repositoty

import com.yourcompany.android.craftynotebook.data.local.NotesDataSource
import com.yourcompany.android.craftynotebook.domain.reposiotory.NoteRepository
import kotlinx.coroutines.flow.flow

class NoteRepositoryImpl: NoteRepository {
    override fun getNotes() = flow {
        val notes = NotesDataSource.notes
        emit(notes)
    }

    override fun getDeletedNotes() = flow{
        val deletedNotes = NotesDataSource.deletedNotes
        emit(deletedNotes)
    }
}
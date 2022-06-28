package com.yourcompany.android.craftynotebook.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yourcompany.android.craftynotebook.domain.model.Note
import com.yourcompany.android.craftynotebook.domain.reposiotory.NoteRepository
import com.yourcompany.android.craftynotebook.data.repositoty.NoteRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NotesViewModel(
    private val repository: NoteRepository = NoteRepositoryImpl()
) : ViewModel() {

    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>>
        get() = _notes

    private val _deletedNotes = MutableStateFlow<List<Note>>(emptyList())
    val deletedNotes: StateFlow<List<Note>>
        get() = _deletedNotes

    fun getNotes() {
        viewModelScope.launch {
            val result = repository.getNotes()
            result.collect { notesList ->
                _notes.value = notesList
            }
        }
    }

    fun getDeletedNotes() {
        viewModelScope.launch {
            val result = repository.getDeletedNotes()
            result.collect { notesList ->
                _deletedNotes.value = notesList
            }
        }
    }
}
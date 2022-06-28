package com.yourcompany.android.craftynotebook.presentation.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yourcompany.android.craftynotebook.domain.model.Note
import com.yourcompany.android.craftynotebook.presentation.NotesViewModel

@Composable
fun NoteDetailScreen(notesViewModel: NotesViewModel = viewModel(), noteIndex: Int = 0){
    val note: Note = notesViewModel.notes.collectAsState().value[noteIndex]
    NoteDetailComposable(note = note)
}
package com.yourcompany.android.craftynotebook.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yourcompany.android.craftynotebook.data.local.Note
import com.yourcompany.android.craftynotebook.ui.NotesViewModel

@Composable
fun NoteDetailScreen(notesViewModel: NotesViewModel = viewModel(), noteIndex: Int = 0){
    val note: Note = notesViewModel.notes.collectAsState().value[noteIndex]
    NoteDetailComposable(note = note)
}
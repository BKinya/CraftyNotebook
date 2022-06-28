package com.yourcompany.android.craftynotebook.presentation.composables

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yourcompany.android.craftynotebook.presentation.NotesViewModel
import com.yourcompany.android.craftynotebook.presentation.util.ContentType


@Composable
fun NotesScreen(
    getNotes: () -> Unit,
    goToDetailScreen: (noteIndex: Int) -> Unit,
    modifier: Modifier = Modifier,
    notesViewModel: NotesViewModel = viewModel(),
    contentType: ContentType = ContentType.LIST_ONLY,
) {
    val onGetNotes by rememberUpdatedState(newValue = getNotes)
    LaunchedEffect(true) {
        onGetNotes()
    }
    val notes = notesViewModel.notes.collectAsState().value
    if (contentType == ContentType.LIST_AND_DETAIL) {
        NoteListDetailComposable(notes = notes)
    } else {
        NoteListComposable(
            notes = notes,
            onItemSelected = goToDetailScreen
        )
    }
}
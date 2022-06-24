package com.yourcompany.android.craftynotebook.ui.composables

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yourcompany.android.craftynotebook.ui.NotesViewModel
import com.yourcompany.android.craftynotebook.ui.util.ContentType
import com.yourcompany.android.craftynotebook.ui.util.Screen


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
package com.yourcompany.android.craftynotebook.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yourcompany.android.craftynotebook.ui.NotesViewModel

@Preview
@Composable
fun DeletedNotesScreen(
    modifier: Modifier = Modifier,
    notesViewModel: NotesViewModel = viewModel()
) {
    val getDeletedNotes by rememberUpdatedState{notesViewModel.getDeletedNotes()}
    LaunchedEffect(true){
        getDeletedNotes()
    }
    val notes = notesViewModel.deletedNotes.collectAsState().value
    if (notes.isNotEmpty()) {
        DeletedNotesComposable(deletedNotes = notes)
    } else {
        Text(
            text = "No Deleted Notes! 🤪",
            modifier = modifier.fillMaxSize(),
            color = Color.Gray,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center
        )
    }
}
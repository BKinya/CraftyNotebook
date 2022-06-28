package com.yourcompany.android.craftynotebook.presentation.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yourcompany.android.craftynotebook.domain.model.Note

@Preview
@Composable
fun DeletedNotesComposable(modifier: Modifier = Modifier, deletedNotes: List<Note> = emptyList()) {
    LazyColumn{
        itemsIndexed(deletedNotes){index, note ->
            NoteItemComposable(note = note)
        }
    }
}

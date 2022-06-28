package com.yourcompany.android.craftynotebook.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yourcompany.android.craftynotebook.domain.model.Note

@Composable
fun NoteListComposable(
    onItemSelected: (Int) -> Unit,
    notes: List<Note>,
    modifier: Modifier = Modifier,

    ) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        itemsIndexed(notes) { index, note ->
            NoteItemComposable(
                modifier = modifier.clickable {
                    onItemSelected(index)
                },
                note = note,
            )
        }
    }
}

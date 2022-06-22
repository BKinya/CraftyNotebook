package com.yourcompany.android.craftynotebook.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yourcompany.android.craftynotebook.data.local.Note
import com.yourcompany.android.craftynotebook.data.local.NotesDataSource
import com.yourcompany.android.craftynotebook.data.local.NotesDataSource.notes
import com.yourcompany.android.craftynotebook.ui.theme.CraftyNotebookTheme
import com.yourcompany.android.craftynotebook.ui.util.Screen

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

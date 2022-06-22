package com.yourcompany.android.craftynotebook.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yourcompany.android.craftynotebook.data.local.Note

@Composable
fun NoteListDetailComposable(
    notes: List<Note>,
    modifier: Modifier = Modifier,
    selectedIndex: MutableState<Int> = rememberSaveable { mutableStateOf(0) }
) {
    Row(
        modifier = modifier,
    ) {
        NoteListComposable(
            notes = notes,
            modifier = modifier.weight(1f),
            onItemSelected = { index ->
                selectedIndex.value = index
            })

        val note = notes[selectedIndex.value]
        NoteDetailComposable(modifier = modifier.weight(1f), note = note)
    }
}
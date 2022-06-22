package com.yourcompany.android.craftynotebook.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yourcompany.android.craftynotebook.data.local.Note
import com.yourcompany.android.craftynotebook.ui.theme.CraftyNotebookTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NoteItemComposable(
    modifier: Modifier = Modifier,
    note: Note = Note(subject = "ABCTf", text = "asdfasdf"),
) {
    Card(
        modifier = modifier.padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
        ) {
            Text(
                text = note.subject,
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.padding(vertical = 2.dp))

            Text(
                text = "${note.text.subSequence(0, 25)}...",
                fontFamily = FontFamily.Serif,
                fontSize = 19.sp,
                fontWeight = FontWeight.Medium,
            )

        }
    }
}

@Preview
@Composable
fun BookItemPreview() {
    CraftyNotebookTheme {
        NoteItemComposable()
    }
}
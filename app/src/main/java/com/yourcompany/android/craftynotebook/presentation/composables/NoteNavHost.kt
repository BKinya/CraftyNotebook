package com.yourcompany.android.craftynotebook.presentation.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yourcompany.android.craftynotebook.presentation.NotesViewModel
import com.yourcompany.android.craftynotebook.presentation.util.ContentType
import com.yourcompany.android.craftynotebook.presentation.util.Screen

@Composable
fun NoteNavHost(
  modifier: Modifier = Modifier,
  navController: NavHostController = rememberNavController(),
  notesViewModel: NotesViewModel = viewModel(),
  contentType: ContentType
) {
  NavHost(
    navController = navController,
    startDestination = Screen.Notes.route,
    modifier = modifier
  ) {
    composable(Screen.Notes.route) {
      NotesScreen(
        notesViewModel = notesViewModel,
        contentType = contentType,
        getNotes = { notesViewModel.getNotes() },
        goToDetailScreen = { index ->
          val route = Screen.NoteDetail.createRoute(index)
          navController.navigate(route)
        }
      )
    }
    composable(Screen.NoteDetail.route) { backStackEntry ->
      val noteIndex =
        backStackEntry.arguments?.getString("noteIndex")?.toInt() ?: 0
      NoteDetailScreen(
        notesViewModel = notesViewModel,
        noteIndex = noteIndex
      )
    }
    composable(Screen.Profile.route) {
      ProfileScreen()
    }
    composable(Screen.DeletedNotes.route) {
      DeletedNotesScreen(notesViewModel = notesViewModel)
    }
  }
}
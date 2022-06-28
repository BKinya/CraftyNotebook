package com.yourcompany.android.craftynotebook.presentation.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.yourcompany.android.craftynotebook.presentation.NotesViewModel
import com.yourcompany.android.craftynotebook.presentation.util.ContentType
import com.yourcompany.android.craftynotebook.presentation.util.NavigationType

@Composable
fun NoteAppContent(
  navigationType: NavigationType,
  modifier: Modifier = Modifier,
  navController: NavHostController = rememberNavController(),
  notesViewModel: NotesViewModel = viewModel(),
  onDrawerClicked: () -> Unit = {},
  contentType: ContentType
) {
  Surface(
    modifier = modifier.fillMaxSize(),
    color = MaterialTheme.colors.background
  ) {
    Row(modifier = Modifier.fillMaxSize()) {
      AnimatedVisibility(visible = navigationType == NavigationType.NAVIGATION_RAIL) {
        NoteNavigationRail(
          onDrawerClicked = onDrawerClicked,
          navController = navController
        )
      }
      Column(
        modifier = modifier.fillMaxSize()
      ) {

        NoteNavHost(
          modifier = modifier.weight(1f),
          contentType = contentType,
          navController = navController,
          notesViewModel = notesViewModel
        )
        AnimatedVisibility(visible = navigationType == NavigationType.BOTTOM_NAVIGATION) {
          NoteBottomNavigationBar(navController = navController)
        }
      }
    }
  }
}
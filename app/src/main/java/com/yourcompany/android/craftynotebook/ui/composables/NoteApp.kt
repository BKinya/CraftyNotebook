package com.yourcompany.android.craftynotebook.ui.composables

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.yourcompany.android.craftynotebook.ui.NotesViewModel
import com.yourcompany.android.craftynotebook.ui.theme.CraftyNotebookTheme
import com.yourcompany.android.craftynotebook.ui.util.ContentType
import com.yourcompany.android.craftynotebook.ui.util.DevicePosture
import com.yourcompany.android.craftynotebook.ui.util.NavigationType

@Composable
fun NoteApp(
  windowSize: WindowWidthSizeClass,
  foldingPosture: DevicePosture,
  notesViewModel: NotesViewModel = viewModel()
) {
  val navController = rememberNavController()
  val navigationType: NavigationType
  val contentType: ContentType
  when (windowSize) {
    WindowWidthSizeClass.Compact -> {
      navigationType = NavigationType.BOTTOM_NAVIGATION
      contentType = ContentType.LIST_ONLY
    }
    WindowWidthSizeClass.Medium -> {
      navigationType = NavigationType.NAVIGATION_RAIL
      contentType = if (foldingPosture is DevicePosture.BookPosture
        || foldingPosture is DevicePosture.Separating
      ) {
        ContentType.LIST_AND_DETAIL
      } else {
        ContentType.LIST_ONLY
      }
    }
    WindowWidthSizeClass.Expanded -> {
      navigationType = if (foldingPosture is DevicePosture.BookPosture) {
        NavigationType.NAVIGATION_RAIL
      } else {
        NavigationType.PERMANENT_NAVIGATION_DRAWER
      }
      contentType = ContentType.LIST_AND_DETAIL
    }
    else -> {
      navigationType = NavigationType.BOTTOM_NAVIGATION
      contentType = ContentType.LIST_ONLY
    }
  }
  NoteNavigationWrapperUi(
    navigationType,
    contentType,
    navController = navController,
    notesViewModel = notesViewModel
  )
}


@Preview(showBackground = true)
@Composable
fun NotePreview() {
  CraftyNotebookTheme {
    NoteApp(
      windowSize = WindowWidthSizeClass.Compact,
      foldingPosture = DevicePosture.NormalPosture
    )
  }
}

@Preview(showBackground = true)
@Composable
fun NotePreviewTablet() {
  CraftyNotebookTheme {
    NoteApp(
      windowSize = WindowWidthSizeClass.Medium,
      foldingPosture = DevicePosture.NormalPosture
    )
  }
}

@Preview(showBackground = true)
@Composable
fun NotePreviewDesktop() {
  CraftyNotebookTheme {
    NoteApp(
      windowSize = WindowWidthSizeClass.Expanded,
      foldingPosture = DevicePosture.NormalPosture
    )
  }
}
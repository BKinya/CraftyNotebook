package com.yourcompany.android.craftynotebook.presentation.composables

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.yourcompany.android.craftynotebook.presentation.NotesViewModel
import com.yourcompany.android.craftynotebook.presentation.util.ContentType
import com.yourcompany.android.craftynotebook.presentation.util.NavigationType
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteNavigationWrapperUi(
    navigationType: NavigationType,
    contentType: ContentType,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    notesViewModel: NotesViewModel = viewModel()
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    if (navigationType == NavigationType.PERMANENT_NAVIGATION_DRAWER) {
        PermanentNavigationDrawer(drawerContent = { NavigationDrawerContent(
            navController = navController
        ) }) {
            NoteAppContent(
                navigationType = navigationType,
                contentType = contentType,
                modifier = modifier,
                navController = navController,
                notesViewModel = notesViewModel
            )
        }
    } else {
        ModalNavigationDrawer(
            drawerContent = {
                NavigationDrawerContent(
                    navController = navController,
                    onDrawerClicked = {
                        scope.launch {
                            drawerState.close()
                        }
                    }
                )
            },
            drawerState = drawerState
        ) {
            NoteAppContent(
                navigationType = navigationType,
                modifier = modifier,
                navController = navController,
                notesViewModel = notesViewModel,
                onDrawerClicked = {
                    scope.launch {
                        drawerState.open()
                    }
                },
                contentType = contentType
            )
        }
    }
}
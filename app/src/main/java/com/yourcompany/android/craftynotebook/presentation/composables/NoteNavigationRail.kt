package com.yourcompany.android.craftynotebook.presentation.composables

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Icon
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yourcompany.android.craftynotebook.R
import com.yourcompany.android.craftynotebook.presentation.util.Screen

@Composable
@Preview
fun NoteNavigationRail(
  onDrawerClicked: () -> Unit = {},
  selectedDestination: String = Screen.Notes.route,
  navController: NavController = rememberNavController()
) {
    NavigationRail(modifier = Modifier.fillMaxHeight()) {
        NavigationRailItem(
            selected = false,
            onClick = onDrawerClicked,
            icon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = stringResource(id = R.string.app_name)
                )
            }
        )
        NavigationRailItem(
            selected = selectedDestination == Screen.Notes.route,
            onClick = { navController.navigate(Screen.Notes.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = stringResource(id = R.string.noteList)
                )
            }
        )
        NavigationRailItem(
            selected = selectedDestination == Screen.Profile.route,
            onClick = { navController.navigate(Screen.Profile.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    stringResource(id = R.string.profile)
                )
            }
        )

        NavigationRailItem(
            selected = selectedDestination == Screen.DeletedNotes.route,
            onClick = { navController.navigate(Screen.DeletedNotes.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Clear,
                    stringResource(id = R.string.deleted)
                )
            }
        )

    }
}
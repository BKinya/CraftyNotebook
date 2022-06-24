package com.yourcompany.android.craftynotebook.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.yourcompany.android.craftynotebook.R
import com.yourcompany.android.craftynotebook.ui.util.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerContent(
  navController: NavController,
  modifier: Modifier = Modifier,
  selectedDestination: String = Screen.Notes.route,
  onDrawerClicked: () -> Unit = {}
) {
  Column(
      modifier
          .wrapContentWidth()
          .fillMaxHeight()
          .background(MaterialTheme.colorScheme.inverseOnSurface)
          .padding(24.dp)
  ) {
    Row(
      modifier = modifier
          .fillMaxWidth()
          .padding(16.dp),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = stringResource(id = R.string.app_name).uppercase(),
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.primary
      )
      IconButton(onClick = onDrawerClicked) {
        Icon(
          imageVector = Icons.Default.Menu,
          contentDescription = stringResource(id = R.string.app_name)
        )
      }
    }

    NavigationDrawerItem(
      selected = selectedDestination == Screen.Notes.route,
      label = {
        Text(
          text = stringResource(id = R.string.noteList),
          modifier = Modifier.padding(horizontal = 16.dp)
        )
      },
      icon = {
        Icon(
          imageVector = Icons.Default.Home,
          contentDescription = stringResource(id = R.string.noteList)
        )
      },
      colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor = Color.Transparent),
      onClick = { navController.navigate(Screen.Notes.route) }
    )
    NavigationDrawerItem(
      selected = selectedDestination == Screen.Profile.route,
      label = {
        Text(
          text = stringResource(id = R.string.profile),
          modifier = Modifier.padding(horizontal = 16.dp)
        )
      },
      icon = {
        Icon(
          imageVector = Icons.Default.Person,
          contentDescription = stringResource(id = R.string.profile)
        )
      },
      colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor = Color.Transparent),
      onClick = { navController.navigate(Screen.Profile.route) }
    )
    NavigationDrawerItem(
      selected = selectedDestination == Screen.DeletedNotes.route,
      label = {
        Text(
          text = stringResource(id = R.string.deleted),
          modifier = Modifier.padding(horizontal = 16.dp)
        )
      },
      icon = {
        Icon(
          imageVector = Icons.Default.Clear,
          contentDescription = stringResource(id = R.string.deleted)
        )
      },
      colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor = Color.Transparent),
      onClick = { navController.navigate(Screen.DeletedNotes.route) }
    )

  }
}
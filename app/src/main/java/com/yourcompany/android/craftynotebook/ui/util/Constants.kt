package com.yourcompany.android.craftynotebook.ui.util

import androidx.annotation.StringRes
import com.yourcompany.android.craftynotebook.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object NoteList : Screen("noteList", R.string.noteList)
    object NoteDetail : Screen("noteDetail", R.string.noteDetail)
    object DeletedNotes: Screen("deletedNotes", R.string.deleted)
    object Profile: Screen("profile", R.string.profile)
}

val destinations = listOf( // TODO: Not sure I'll use this class. Probably remove it
    Screen.NoteList,
    Screen.NoteDetail,
    Screen.Profile,
    Screen.DeletedNotes
)

/**
 * Different type of navigation depending on size and state.
 */
enum class NavigationType {
    BOTTOM_NAVIGATION, NAVIGATION_RAIL, PERMANENT_NAVIGATION_DRAWER
}




/**
 * Content shown depending on size and state of device.
 */
enum class ContentType {
    LIST_ONLY, LIST_AND_DETAIL
}
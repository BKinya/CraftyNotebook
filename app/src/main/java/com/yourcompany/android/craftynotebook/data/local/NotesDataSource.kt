package com.yourcompany.android.craftynotebook.data.local

import com.yourcompany.android.craftynotebook.domain.model.Note

object NotesDataSource {
    val notes = mutableListOf(
        Note(
            subject = "Android",
            text = "Android: You should not lock orientation of activities, so that you can support " +
                    "good  user experience for any device or orientation. \n\nMe: 'Are you sure?' \n\nAndroid: Relax! I'll show you how to."
        ),
        Note(
            subject = "Gradle",
            text = "What's Gradle? \n\nA) The source of 94.3% of Android dev Twitter traffic. \n\nB) A viable means to heat a small room." +
                    "\n\nC) A general purpose tool used for Android and other projects. \n\nD) All the above."
        ),
        Note(
            subject = "Android Studio",
            text = "'No thanks' is not available while Studio is updating indexes."
        ),
        Note(
            subject = "Kotlin",
            text = "Android devs: we love kotlin because it helps with nullability issues.\n" +
                    "\n" +
                    "Also android devs:: !!!!!!!!!!!!!!!!!!!!!!!!!"
        ),
        Note(
            subject = "Kotlin/Java",
            text = "The number of semi-colons in our kotlin code is too damn high! "
        ),
        Note(
            subject = "Null Pointer Exception",
            text = "I'm having such a bad day, that an exception object passed on to my catch block itself caused a NullPointerException."
        ),
        Note(
            subject = "Android Studio",
            text = "Turning useless PC to a useful heater."
        ),

        Note(
            subject = "Android Studio",
            text = "Is this memory, cpu benchmarking tool? Check your system toughness for free!"
        ),
    )

    val deletedNotes = mutableListOf<Note>()
}
package app.chamich.library.preferences.internal

import android.util.Log
import app.chamich.library.preferences.IPreferences

internal class Preferences: IPreferences {

    init {
        Log.d("--| DEBUGGING |--",
            "Preferences object created with ID: ${System.identityHashCode(this)}")
    }

}
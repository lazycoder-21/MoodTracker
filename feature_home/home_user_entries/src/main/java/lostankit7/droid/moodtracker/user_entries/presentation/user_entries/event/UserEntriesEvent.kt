package lostankit7.droid.moodtracker.user_entries.presentation.user_entries.event

import lostankit7.android.entry_domain.entities.UserEntry

sealed class UserEntriesEvent {
    data class ActionDelete(val entry: UserEntry.Entry) : UserEntriesEvent()
    object Refresh : UserEntriesEvent()
}
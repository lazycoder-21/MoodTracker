package lostankit7.android.entry_presentation.utils

import android.os.Bundle
import lostankit7.android.entry_presentation.R
import lostankit7.android.entry_presentation.databinding.CommonActionBarBinding
import lostankit7.android.entry_presentation.fragment.addEntry.AddTaskEntryFragment
import lostankit7.droid.helper.hide
import lostankit7.droid.helper.show

object ActionBarUtils {

    fun CommonActionBarBinding.applyDefault() {
        leftIcon1.text = root.context.resources.getString(R.string.fas_circular_back)
        root.show()
        btnBack.show()
        leftIcon1.show()
        leftIcon2.hide()
        title.hide()
        btnSave.hide()
    }

    fun CommonActionBarBinding.showBackButtonWithIcon(icon: String) {
        leftIcon1.apply {
            text = resources.getString(R.string.fas_back)
        }
        leftIcon2.apply {
            show()
            text = icon
        }
    }

    fun CommonActionBarBinding.showSaveButton() {
        btnSave.show()
    }

    fun CommonActionBarBinding.updateTitle(txt: String) {
        title.apply {
            show()
            text = txt
        }
    }

    fun CommonActionBarBinding.upsertMoodTaskFragment() {
        showSaveButton()
    }

    fun CommonActionBarBinding.addTaskEntryFragment(args: Bundle?) {
        val moodEntry = AddTaskEntryFragment.getMoodEntryFromBundle(args, root.context)
        moodEntry?.apply {
            showBackButtonWithIcon(moodEntry.moodIcon.icon)
            updateTitle(moodEntry.moodIcon.name)
        }
        showSaveButton()
    }

    fun CommonActionBarBinding.addMoodEntryFragment() {
        root.hide()
    }
}
package lostankit7.android.entry_presentation.di

import androidx.fragment.app.FragmentActivity
import dagger.Component
import lostankit7.android.entry_data.di.EntryDatabaseModule
import lostankit7.android.entry_data.di.LocalDbModule
import lostankit7.android.entry_presentation.di.module.ViewModelModule
import lostankit7.android.entry_presentation.fragment.addEntry.AddMoodEntryFragment
import lostankit7.android.entry_presentation.fragment.addEntry.AddTaskEntryFragment
import lostankit7.android.entry_presentation.fragment.editEntry.editmood.DisplayMoodIconsFragment
import lostankit7.android.entry_presentation.fragment.editEntry.editmood.UpsertMoodIconFragment
import lostankit7.android.entry_presentation.fragment.editEntry.edittask.DisplayTaskCategoriesFragment
import lostankit7.android.entry_presentation.fragment.editEntry.edittask.DisplayTasksOfCategoryFragment
import lostankit7.android.entry_presentation.fragment.editEntry.edittask.UpsertTaskIconFragment
import lostankit7.droid.moodtracker.core.di.component.CoreAppComponent
import lostankit7.droid.moodtracker.core.di.component.CoreAppComponent.Companion.coreAppComponent

@Component(modules = [
    ViewModelModule::class,
    EntryDatabaseModule::class, LocalDbModule::class
], dependencies = [CoreAppComponent::class])
interface EntryComponent {

    companion object {
        val FragmentActivity.entryComponent: EntryComponent
            get() = DaggerEntryComponent.builder()
                .coreAppComponent(application.coreAppComponent)
                .build()
    }

    fun inject(frag: AddMoodEntryFragment)
    fun inject(frag: AddTaskEntryFragment)
    fun inject(frag: UpsertMoodIconFragment)
    fun inject(frag: UpsertTaskIconFragment)
    fun inject(frag: DisplayMoodIconsFragment)
    fun inject(frag: DisplayTasksOfCategoryFragment)
    fun inject(frag: DisplayTaskCategoriesFragment)
}
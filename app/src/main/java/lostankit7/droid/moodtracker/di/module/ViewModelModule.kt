package lostankit7.droid.moodtracker.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import lostankit7.droid.moodtracker.core_presentation.di.viewmodel.ViewModelKey
import lostankit7.droid.moodtracker.presentation.splash.MainViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindsMainViewModel(mainViewModel: MainViewModel): ViewModel
}
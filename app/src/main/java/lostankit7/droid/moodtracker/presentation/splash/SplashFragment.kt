package lostankit7.droid.moodtracker.presentation.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.core.presentation.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.core.utils.Constants
import lostankit7.droid.moodtracker.databinding.FragmentSplashBinding
import lostankit7.droid.moodtracker.di.component.AppComponent.Companion.appComponent

class SplashFragment : BaseDaggerFragment<FragmentSplashBinding, SplashViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.saveDefaultIcons(
            SplashFragmentDataProvider.moodIcons(requireContext()),
            SplashFragmentDataProvider.suggestedMoodIcons(),
            SplashFragmentDataProvider.taskCategories(requireContext()),
            SplashFragmentDataProvider.taskIcons(requireContext()),
            SplashFragmentDataProvider.suggestedTaskIcons(),
            SplashFragmentDataProvider.suggestedMoodNames(requireContext()),
            SplashFragmentDataProvider.suggestedTaskNames(requireContext())
        )

        lifecycleScope.launchWhenCreated {
            delay(Constants.SPLASH_TIME)
            navigateAfterSplash()
        }

    }

    private fun navigateAfterSplash() {
        //todo launch as single top
        navController.navigate(R.id.nav_graph_home)
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentSplashBinding.inflate(layoutInflater)

    override fun injectFragment() {
        activity?.appComponent?.inject(this)
    }

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[SplashViewModel::class.java]
}
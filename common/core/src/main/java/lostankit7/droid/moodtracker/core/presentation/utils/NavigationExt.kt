package lostankit7.droid.moodtracker.core.presentation.utils

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import lostankit7.droid.moodtracker.core.R

@Suppress("UNCHECKED_CAST")
fun <F : Fragment> AppCompatActivity.getFragment(fragmentClass: Class<F>): F? {
    (this.supportFragmentManager.fragments.first() as? NavHostFragment)?.apply {
        childFragmentManager.fragments.forEach {
            if (fragmentClass.isAssignableFrom(it.javaClass)) {
                return it as F
            }
        }
    }
    return null
}

/** function to find root nav host i.e., nav controller of Main Activity */
val Fragment.findRootNavHost: NavController?
    get() = this.activity?.let { Navigation.findNavController(it, R.id.fragment_container_root) }

fun Fragment.findNavHost(@IdRes viewId: Int): NavController {
    val navHostFragment = childFragmentManager
        .findFragmentById(viewId) as NavHostFragment
    return navHostFragment.navController
}

/** returns primary fragment, in the [containerId]*/
fun Fragment.getCurrentFragment(@IdRes containerId: Int) =
    run { childFragmentManager.findFragmentById(containerId)?.childFragmentManager?.primaryNavigationFragment }

private const val NO_ANIMATION = -1
private const val ANIMATE_TOP_BOTTOM = 1

fun navOptions(
    enter: Int,
    exit: Int,
    reverse: Boolean = true,
) = NavOptions.Builder().setEnterAnim(enter).setPopExitAnim(exit).also {
    if (reverse) it.setPopEnterAnim(exit).setExitAnim(enter)
}.build()

fun navOptions(
    enter: Int = NO_ANIMATION,
    popExit: Int = NO_ANIMATION,
    exit: Int = NO_ANIMATION,
    popEnter: Int = NO_ANIMATION,
) = NavOptions.Builder().also {
    if (enter != NO_ANIMATION) it.setEnterAnim(enter)
    if (popExit != NO_ANIMATION) it.setPopExitAnim(popExit)
    if (exit != NO_ANIMATION) it.setExitAnim(exit)
    if (popEnter != NO_ANIMATION) it.setPopEnterAnim(popEnter)
}.build()

fun navOptions(animation: Int, reverse: Boolean = true): NavOptions {
    val enter: Int
    val exit: Int
    when (animation) {
        ANIMATE_TOP_BOTTOM -> {
            enter = R.anim.anim_bottom_to_top
            exit = R.anim.anim_top_to_bottom
        }
        else -> {
            enter = NO_ANIMATION
            exit = NO_ANIMATION
        }
    }

    return NavOptions.Builder().also {
        it.setEnterAnim(enter)
        if (reverse) it.setExitAnim(exit)
        if (reverse) it.setPopEnterAnim(enter)
        it.setPopExitAnim(exit)
    }.build()
}
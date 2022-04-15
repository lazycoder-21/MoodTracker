package lostankit7.droid.moodtracker.ui.fragment.displayentry

class AllUserEntriesFragment : UserEntriesBaseFragment() {

    override suspend fun registerObservers() {
        super.registerObservers()

        viewModel.userEntries.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

}
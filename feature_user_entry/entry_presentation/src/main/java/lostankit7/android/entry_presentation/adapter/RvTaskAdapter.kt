package lostankit7.android.entry_presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lostankit7.android.entry_domain.entities.TaskCategory
import lostankit7.android.entry_presentation.R
import lostankit7.android.entry_presentation.databinding.ItemRvExpandableViewBinding
import lostankit7.droid.moodtracker.core.domain.entities.shared.BaseIcon
import lostankit7.droid.moodtracker.core.presentation.base.adapter.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.core.presentation.utils.ViewExt.hide
import lostankit7.droid.moodtracker.core.presentation.utils.ViewExt.show

class RvTaskAdapter(
    private val getTaskIcons: (String, TaskIconRvAdapter) -> Unit,
    private val taskSelected: (BaseIcon) -> Unit
) : BaseDiffRvAdapter<ItemRvExpandableViewBinding, TaskCategory>() {

    override fun bindViewHolder(
        item: TaskCategory, position: Int, binding: ItemRvExpandableViewBinding
    ) {

        binding.txtTitle.text = item.name

        binding.toggleTaskCategory(item, true)
        binding.rvItems.setUpRecyclerView(item.name)

        binding.tvDropDownIcon.setOnClickListener { binding.toggleTaskCategory(item) }
        binding.llTaskCategory.setOnClickListener { binding.toggleTaskCategory(item) }
    }

    private fun ItemRvExpandableViewBinding.toggleTaskCategory(
        item: TaskCategory,
        isInitial: Boolean = false
    ) {
        if (!isInitial) item.isExpanded = !item.isExpanded
        if (item.isExpanded) {
            tvDropDownIcon.text = this.root.context.resources.getString(R.string.fas_collapse)
            rvItems.show()
        } else {
            tvDropDownIcon.text = this.root.context.resources.getString(R.string.fas_expand)
            rvItems.hide()
        }
    }

    private fun RecyclerView.setUpRecyclerView(category: String) {
        layoutManager = GridLayoutManager(context, SPAN_COUNT_TASK_RV)

        val mAdapter = TaskIconRvAdapter.newInstance(taskSelected, true)
        adapter = mAdapter

        getTaskIcons.invoke(category, mAdapter)
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean
    ) = ItemRvExpandableViewBinding.inflate(layoutInflater, parent, attachToParent)

    private companion object {
        const val SPAN_COUNT_TASK_RV = 5
    }
}


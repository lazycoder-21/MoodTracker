package lostankit7.android.entry_presentation.adapter

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import lostankit7.android.entry_domain.entities.MoodIcon
import lostankit7.android.entry_domain.entities.TaskIcon
import lostankit7.android.entry_presentation.R
import lostankit7.android.entry_presentation.databinding.ItemIconWithTextListBinding
import lostankit7.droid.moodtracker.core.domain.entities.shared.BaseIcon
import lostankit7.droid.moodtracker.core.presentation.base.adapter.BaseDiffRvAdapter
import lostankit7.droid.moodtracker.core.presentation.base.adapter.BaseViewHolder
import lostankit7.droid.moodtracker.core.presentation.utils.DialogHelper

class IconListRvAdapter(
    private val itemClick: (BaseIcon) -> Unit,
    private val optionsSelected: (MenuItem, BaseIcon) -> Boolean
) : BaseDiffRvAdapter<ItemIconWithTextListBinding, BaseIcon>() {

    override fun onCreateHolder(
        holder: BaseViewHolder<ItemIconWithTextListBinding>,
        parent: ViewGroup, viewType: Int,
    ) {
        super.onCreateHolder(holder, parent, viewType)

        holder.binding.root.setOnClickListener { itemClick(getItem(holder.adapterPosition)) }
        holder.binding.optionMenu.setOnClickListener {
            DialogHelper.showMenu(
                parent.context, holder.binding.optionMenu, R.menu.menu_options_item_user_entries
            ) { optionsSelected(it, getItem(holder.adapterPosition)) }
        }
    }

    override fun bindViewHolder(item: BaseIcon, position: Int, binding: ItemIconWithTextListBinding) {

        if (item.isSolid) binding.faIcon.isSolidIcon() else binding.faIcon.isRegularIcon()
        binding.tvName.text = item.name
        binding.faIcon.text = item.icon

        when (item) {
            is MoodIcon -> {
                binding.faIcon.isRegularIcon()
            }
            is TaskIcon -> {
                binding.faIcon.isSolidIcon()
            }
        }
    }

    override fun inflateLayout(
        layoutInflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean
    ) = ItemIconWithTextListBinding.inflate(layoutInflater, parent, attachToParent)

}
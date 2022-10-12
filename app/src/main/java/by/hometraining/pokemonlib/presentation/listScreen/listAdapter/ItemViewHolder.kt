package by.hometraining.pokemonlib.presentation.listScreen.listAdapter

import androidx.recyclerview.widget.RecyclerView
import by.hometraining.pokemonlib.presentation.model.ListItem
import by.hometrainng.pokemonlib.databinding.ListItemBinding

class ItemViewHolder(
    private val binding: ListItemBinding,
    private val onClicked: (ListItem.Pokemon) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ListItem.Pokemon) {
        binding.pokemonName.text = item.name
        binding.root.setOnClickListener {
            onClicked(item)
        }
    }
}
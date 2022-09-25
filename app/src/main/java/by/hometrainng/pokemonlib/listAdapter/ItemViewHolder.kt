package by.hometrainng.pokemonlib.listAdapter

import androidx.recyclerview.widget.RecyclerView
import by.hometrainng.pokemonlib.databinding.ListItemBinding
import by.hometrainng.pokemonlib.model.Pokemon

class ItemViewHolder(
    private val binding: ListItemBinding,
    private val onClicked: (Pokemon) -> Unit
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Pokemon) {
        binding.pokemonName.text = item.name

        binding.root.setOnClickListener {
            onClicked(item)
        }
    }
}
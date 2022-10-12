package by.hometraining.pokemonlib.presentation.listScreen.listAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.hometraining.pokemonlib.presentation.model.ListItem
import by.hometrainng.pokemonlib.databinding.ListItemBinding
import by.hometrainng.pokemonlib.databinding.LoadingItemBinding

class PokemonListAdapter(
    private val onClicked: (ListItem.Pokemon) -> Unit
) : ListAdapter<ListItem, RecyclerView.ViewHolder>(DIFF_UTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_POKEMON -> {
                ItemViewHolder(
                    binding = ListItemBinding.inflate(layoutInflater, parent, false),
                    onClicked = onClicked
                )
            }
            TYPE_LOADING -> {
                LoadingViewHolder(
                    binding = LoadingItemBinding.inflate(layoutInflater, parent, false)
                )
            }
            else -> {
                error("Unknown View Type")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val pokemonViewHolder = holder as? ItemViewHolder ?: return
        val item = getItem(position) as? ListItem.Pokemon ?: return
        pokemonViewHolder.bind(item)
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ListItem.Pokemon -> TYPE_POKEMON
            ListItem.Loading -> TYPE_LOADING
        }
    }

    companion object {

        private const val TYPE_POKEMON = 0
        private const val TYPE_LOADING = 1

        private val DIFF_UTIL = object : DiffUtil.ItemCallback<ListItem>() {
            override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}
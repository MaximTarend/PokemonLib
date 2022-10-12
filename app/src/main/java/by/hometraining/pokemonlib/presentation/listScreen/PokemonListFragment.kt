package by.hometraining.pokemonlib.presentation.listScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.hometraining.pokemonlib.addPaginationScrollListener
import by.hometraining.pokemonlib.addSpaceDecoration
import by.hometraining.pokemonlib.presentation.listScreen.listAdapter.PokemonListAdapter
import by.hometraining.pokemonlib.presentation.model.ListItem
import by.hometraining.pokemonlib.presentation.model.toListItem
import by.hometrainng.pokemonlib.databinding.FragmentPokemonListBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonListFragment : Fragment() {

    private var _binding: FragmentPokemonListBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val listViewModel by viewModel<ListViewModel>()

    private val adapter by lazy {
        PokemonListAdapter {
            findNavController().navigate(PokemonListFragmentDirections.toDetails(it.name))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentPokemonListBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(view.context)

        with(binding) {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = layoutManager
            progressCircular.isVisible = true
            recyclerView.isVisible = false
            recyclerView.addSpaceDecoration(SPACE)
            recyclerView.addPaginationScrollListener(layoutManager, ITEMS_TO_LOAD) {
                listViewModel.onLoadMore()
            }
            showPokemonList()
        }
    }

    private fun showPokemonList() {
        with(binding) {
            listViewModel
                .loadDataFlow
                .onEach { list ->
                    progressCircular.isVisible = false
                    recyclerView.isVisible = true
                    if (list.size != SIZE) {
                        adapter.submitList(list.map { it.toListItem() } + ListItem.Loading)
                    } else {
                        adapter.submitList(list.map { it.toListItem() })
                    }
                }
                .launchIn(viewLifecycleOwner.lifecycleScope)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun toast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val SPACE = 12
        private const val ITEMS_TO_LOAD = 30
        private const val SIZE = 1154
    }
}
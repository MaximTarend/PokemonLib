package by.hometrainng.pokemonlib.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.hometrainng.pokemonlib.addPaginationScrollListener
import by.hometrainng.pokemonlib.addSpaceDecoration
import by.hometrainng.pokemonlib.databinding.FragmentPokemonListBinding
import by.hometrainng.pokemonlib.listAdapter.PokemonListAdapter
import by.hometrainng.pokemonlib.viewModels.PokemonListViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonListFragment : Fragment() {

    private var _binding: FragmentPokemonListBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val listViewModel by viewModel<PokemonListViewModel>()

    private val adapter by lazy {
        PokemonListAdapter(requireContext()) { pokemon ->
            findNavController().navigate(PokemonListFragmentDirections.toDetails(pokemon.name))
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
            recyclerView.addSpaceDecoration(SPACE)
            recyclerView.addPaginationScrollListener(layoutManager, ITEMS_TO_LOAD) {
                listViewModel.onLoadMore()
            }

            listViewModel
                .loadDataFlow
                .onEach {
                    adapter.submitList(it)
                    println()
                }
                .launchIn(viewLifecycleOwner.lifecycleScope)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val SPACE = 12
        private const val ITEMS_TO_LOAD = 30
    }
}
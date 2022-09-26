package by.hometrainng.pokemonlib.fragments

import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.hometrainng.pokemonlib.addPaginationScrollListener
import by.hometrainng.pokemonlib.addSpaceDecoration
import by.hometrainng.pokemonlib.databinding.FragmentPokemonListBinding
import by.hometrainng.pokemonlib.extentions.networkChanges
import by.hometrainng.pokemonlib.listAdapter.PokemonListAdapter
import by.hometrainng.pokemonlib.model.ListItem
import by.hometrainng.pokemonlib.model.toListItem
import by.hometrainng.pokemonlib.viewModels.ListViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonListFragment : Fragment() {

    private var _binding: FragmentPokemonListBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val listViewModel by viewModel<ListViewModel>()

    private val adapter by lazy {
        PokemonListAdapter(requireContext()) {
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

/*        val networkChanges = requireContext().networkChanges
        networkChanges.onEach {
            if (it) {
                toast(ONLINE_MODE)
            } else { toast(OFFLINE_MODE) }
        }*/

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
                .onEach { list ->
                    adapter.submitList(list.map { it.toListItem() } + ListItem.Loading)
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
        private const val ONLINE_MODE = "Online mode"
        private const val OFFLINE_MODE = "Offline mode"
    }
}
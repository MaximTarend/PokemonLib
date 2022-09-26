package by.hometrainng.pokemonlib.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import by.hometrainng.pokemonlib.R
import by.hometrainng.pokemonlib.databinding.FragmentPokemonDetailsBinding
import by.hometrainng.pokemonlib.viewModels.DetailsViewModel
import coil.load
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PokemonDetailsFragment: Fragment() {

    private var _binding: FragmentPokemonDetailsBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val args by navArgs<PokemonDetailsFragmentArgs>()

    private val detailsViewModel by viewModel<DetailsViewModel> {
        parametersOf(args.pokemonName)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentPokemonDetailsBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            detailsToolbar.setupWithNavController(findNavController())

            detailsViewModel
                .loadDetailsFlow
                .onEach { pokemonDetails ->
                    println()
                    pokemonName.text = pokemonDetails.name
                    image.load(pokemonDetails.imageURL)
                    weight.text = "$WEIGHT_PREFIX ${pokemonDetails.weight* WEIGHT_K} $WEIGHT_POSTFIX"
                    height.text = "$HEIGHT_PREFIX ${pokemonDetails.height* HEIGHT_K} $HEIGHT_POSTFIX"
                    types.text = "${TYPE_PREFIX} ${pokemonDetails.types.joinToString(SEPARATOR)}"
                }.launchIn(viewLifecycleOwner.lifecycleScope)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val HEIGHT_K = 10
        private const val WEIGHT_K = 0.1
        private const val TYPE_PREFIX = "TYPE:\n\n"
        private const val WEIGHT_PREFIX = "WEIGHT: "
        private const val WEIGHT_POSTFIX = " kg"
        private const val HEIGHT_PREFIX = "HEIGHT: "
        private const val HEIGHT_POSTFIX = " cm"
        private const val SEPARATOR = ", "
    }
}
package by.hometrainng.pokemonlib.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import by.hometrainng.pokemonlib.R
import by.hometrainng.pokemonlib.databinding.FragmentPokemonDetailsBinding
import by.hometrainng.pokemonlib.extentions.networkChanges
import by.hometrainng.pokemonlib.model.LceState
import by.hometrainng.pokemonlib.model.PokemonDetails
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

/*        val networkChanges = requireContext().networkChanges
        networkChanges.onEach {
            if (it) {
                toast(ONLINE_MODE)
            } else { toast(OFFLINE_MODE) }
        }*/

        with(binding) {
            detailsToolbar.setupWithNavController(findNavController())

            detailsViewModel
                .loadDetailsFlow
                .onEach { pokemonDetailsState ->
                    contentLayout.isVisible = pokemonDetailsState is LceState.Content
                    progressCircular.isVisible = pokemonDetailsState == LceState.Loading
                    when(pokemonDetailsState) {
                        is LceState.Content<PokemonDetails> -> {
                            val pokemonDetails = pokemonDetailsState.data
                            pokemonName.text = pokemonDetails.name
                            image.load(pokemonDetails.imageURL)
                            weight.text = "$WEIGHT_PREFIX ${pokemonDetails.weight* WEIGHT_K} $WEIGHT_POSTFIX"
                            height.text = "$HEIGHT_PREFIX ${pokemonDetails.height* HEIGHT_K} $HEIGHT_POSTFIX"
                            types.text = "${TYPE_PREFIX} ${pokemonDetails.types.joinToString(SEPARATOR)}"
                        }
                        is LceState.Error -> {
                            toast(pokemonDetailsState.throwable.message ?: UPLOAD_FAILURE)
                        }
                    }

                }.launchIn(viewLifecycleOwner.lifecycleScope)

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

        private const val HEIGHT_K = 10
        private const val WEIGHT_K = 0.1
        private const val TYPE_PREFIX = "TYPE:\n\n"
        private const val WEIGHT_PREFIX = "WEIGHT: "
        private const val WEIGHT_POSTFIX = " kg"
        private const val HEIGHT_PREFIX = "HEIGHT: "
        private const val HEIGHT_POSTFIX = " cm"
        private const val SEPARATOR = ", "
        private const val ONLINE_MODE = "Online mode"
        private const val OFFLINE_MODE = "Offline mode"
        private const val UPLOAD_FAILURE = "Upload failure"
    }
}
package digital.overman.foosballmeet.ui.standings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import digital.overman.foosballmeet.R
import digital.overman.foosballmeet.databinding.StandingsFragmentBinding
import digital.overman.foosballmeet.domain.StandingsViewModel

class StandingsFragment : Fragment() {

    private val viewModel: StandingsViewModel by viewModels()
    private lateinit var binding: StandingsFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.standings_fragment, container, false)
        val playerListObserver = Observer<String> { newList ->
            Log.d(Companion.TAG, "New player list observed")
            binding.playerlistTv.text = newList
        }
        val dumbyObserver = Observer<Int> { newInt ->
            Log.d(Companion.TAG, "New dumby value observed")
            binding.dumbyTv.text = newInt.toString()
        }

        viewModel.dumby.observe(viewLifecycleOwner, dumbyObserver)
        viewModel.players.observe(viewLifecycleOwner, playerListObserver)

        binding.fab.setOnClickListener { viewModel.addMatchClicked() }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
    }

    companion object {
        private const val TAG = "StandingsFragment"
    }
}
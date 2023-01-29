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
import digital.overman.foosballmeet.ui.AddGameFragment

class StandingsFragment : Fragment() {

    private val viewModel: StandingsViewModel by viewModels()
    private lateinit var binding: StandingsFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.standings_fragment, container, false)

        val playerListObserver = Observer<String> {
            Log.d(TAG, "New player list observed")
            binding.playerlistTv.text = viewModel.getPlayerList()
        }
        viewModel.players.observe(viewLifecycleOwner, playerListObserver)


        binding.fab.setOnClickListener {
            Log.d(TAG, "fragment trans to add game")
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, AddGameFragment())
                .addToBackStack("add_game_fragment")
                .commit()
        }
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
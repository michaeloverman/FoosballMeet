package digital.overman.foosballmeet.ui.standings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import digital.overman.foosballmeet.R
import digital.overman.foosballmeet.data.Player
import digital.overman.foosballmeet.databinding.StandingsFragmentBinding
import digital.overman.foosballmeet.domain.StandingsViewModel
import digital.overman.foosballmeet.ui.AddGameFragment

class StandingsFragment : Fragment() {

    private val viewModel: StandingsViewModel by viewModels()
    private lateinit var binding: StandingsFragmentBinding
    private val playerAdapter by lazy { PlayerAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.standings_fragment, container, false)

        binding.apply {
            reduceReuseRecycle.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = playerAdapter
            }
        }

        val playerListObserver = Observer<List<Player>> { list ->
            Log.d(TAG, "New player list observed: ${list.joinToString { "${it.name}, " }}")
//            binding.playerlistTv.text = viewModel.getPlayerList()
            playerAdapter.differ.submitList(viewModel.getPlayerList())
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
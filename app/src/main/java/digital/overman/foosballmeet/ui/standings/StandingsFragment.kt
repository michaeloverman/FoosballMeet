package digital.overman.foosballmeet.ui.standings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import digital.overman.foosballmeet.R
import digital.overman.foosballmeet.databinding.StandingsFragmentBinding
import digital.overman.foosballmeet.domain.StandingsViewModel
import javax.inject.Inject

@AndroidEntryPoint
class StandingsFragment : Fragment() {

    @Inject lateinit var viewModel: StandingsViewModel
    private lateinit var binding: StandingsFragmentBinding

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.standings_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.standingsViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }
}
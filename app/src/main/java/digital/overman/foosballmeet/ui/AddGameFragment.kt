package digital.overman.foosballmeet.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import digital.overman.foosballmeet.R
import digital.overman.foosballmeet.data.Match
import digital.overman.foosballmeet.databinding.FragmentAddGameBinding
import digital.overman.foosballmeet.domain.StandingsViewModel


class AddGameFragment : Fragment() {

    private val viewModel: StandingsViewModel by viewModels()
    private lateinit var binding: FragmentAddGameBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_game, container, false)

        binding.floatingActionButton.setOnClickListener {
            val one = binding.nameOne.text.toString().trim()
            val two = binding.nameTwo.text.toString().trim()
            val s1 = binding.scoreOne.text.toString().trim()
            val s2 = binding.scoreTwo.text.toString().trim()

            if (one.isNotBlank() && two.isNotBlank() && s1.isNotBlank() && s2.isNotBlank()) {
                viewModel.addMatch(Match(one, s1.toInt(), two, s2.toInt()))
                parentFragmentManager.popBackStack()
            } else {
                Toast.makeText(context, "A value must be entered in each field", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }

    companion object {
        private const val TAG = "AddGameFragment"
    }
}
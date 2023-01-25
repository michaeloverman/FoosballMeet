package digital.overman.foosballmeet.domain

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import digital.overman.foosballmeet.data.PlayersRepository
import javax.inject.Inject

class StandingsViewModel @Inject constructor(): ViewModel() {
    val players: MutableList<String> = mutableListOf("Ada", "Bob", "Cao", "Don", "Ice Cream")
}
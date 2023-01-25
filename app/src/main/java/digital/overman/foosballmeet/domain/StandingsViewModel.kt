package digital.overman.foosballmeet.domain

import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import digital.overman.foosballmeet.data.PlayersRepository
import javax.inject.Inject

class StandingsViewModel @Inject constructor(var repository: PlayersRepository): ViewModel() {
    val players = repository.players
}
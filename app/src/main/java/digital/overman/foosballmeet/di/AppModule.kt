package digital.overman.foosballmeet.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import digital.overman.foosballmeet.data.PlayersRepository
import digital.overman.foosballmeet.domain.StandingsViewModel
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePlayersRepository(): PlayersRepository {
        return PlayersRepository
    }
}
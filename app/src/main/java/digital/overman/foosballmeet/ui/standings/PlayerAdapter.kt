package digital.overman.foosballmeet.ui.standings

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import digital.overman.foosballmeet.R
import digital.overman.foosballmeet.data.Player
import digital.overman.foosballmeet.databinding.PlayerListViewBinding

class PlayerAdapter : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    private lateinit var binding: PlayerListViewBinding
    lateinit var res: Resources

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        binding = PlayerListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder()
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
        holder.setIsRecyclable(false)
    }

    override fun getItemCount() = differ.currentList.size

    inner class PlayerViewHolder : RecyclerView.ViewHolder(binding.root) {
        fun bind(player: Player) {
            binding.name.text = player.name
            binding.wins.text = player.winCount.toString()
            binding.losses.text = (player.matchCount - player.winCount).toString()
            val res = this.itemView.resources
            binding.percentage.text = String.format(res.getString(R.string.player_percentage),(player.winPercentage() * 100).toInt())
        }
    }

    private val differCallBack = object : DiffUtil.ItemCallback<Player>() {
        override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)
}
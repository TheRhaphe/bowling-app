package zw.co.brighton.bowling

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import zw.co.brighton.bowling.databinding.FrameItemBinding
import zw.co.brighton.bowling.models.BowlingGame

class ScoreFrameAdapter(
    private val bowlingGame: BowlingGame
): RecyclerView.Adapter<ScoreFrameAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: FrameItemBinding

        init {
            binding = FrameItemBinding.bind(view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.frame_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = bowlingGame.frames.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val frame = bowlingGame.frames[position]
        if (frame.hasStrike()) {
            holder.binding.score1.visibility = View.GONE
            holder.binding.score2.visibility = View.GONE
            holder.binding.score3.visibility = View.VISIBLE
            holder.binding.score3.text = "■"
        } else {
            holder.binding.score1.text = cleanedScore(frame.getFirstScore())
            holder.binding.score2.text = cleanedScore(frame.getSecondScore())
            holder.binding.score1.visibility = View.VISIBLE
            holder.binding.score2.visibility = View.VISIBLE
            if (frame.isLastFrame) {
                holder.binding.score3.text = cleanedScore(frame.getThirdScore())
                holder.binding.score3.visibility = View.VISIBLE
            }
            else holder.binding.score3.visibility = View.GONE
        }
        holder.binding.frameScore.text = "${bowlingGame.getFrameScore(position)}"
        holder.binding.frameNumber.text = String.format(
            holder.itemView.resources.getString(R.string.frame_label), position+1)
    }

    private fun cleanedScore(score: Int): String {
        return when(score) {
            BowlingGame.STRIKE -> "■"
            BowlingGame.SPARE -> "◢"
            else -> "$score"
        }
    }
}
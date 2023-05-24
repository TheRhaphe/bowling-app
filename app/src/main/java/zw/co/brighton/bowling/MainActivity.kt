package zw.co.brighton.bowling

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import zw.co.brighton.bowling.databinding.ActivityMainBinding
import zw.co.brighton.bowling.models.BowlingGame


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val game = BowlingGame()

        val dividerItemDecoration = DividerItemDecoration(
            binding.recyclerView.context,
            HORIZONTAL
        )

        binding.recyclerView.addItemDecoration(dividerItemDecoration)
        binding.recyclerView.adapter = ScoreFrameAdapter(game)
    }
}
package com.example.madlevel4task2v2.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.madlevel4task2v2.R
import com.example.madlevel4task2v2.model.Game
import kotlinx.android.synthetic.main.fragment_game.*
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GameFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Title of the screen in the actionbar
        (activity as MainActivity).supportActionBar?.title = "Rock Paper Scissors"
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initGame()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_history, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    //Action going to history screen
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.history -> {
                findNavController().navigate(R.id.action_gameFragment_to_historyFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initGame() {
        ivRock.setOnClickListener{ playGame(Game.Move.ROCK) }
        ivPaper.setOnClickListener{ playGame(Game.Move.PAPER) }
        ivScissors.setOnClickListener{ playGame(Game.Move.SCISSORS) }
    }


    private fun playGame(move: Game.Move) {
        val computerMove = Game.Move.values().toList().shuffled().first()

        val result = (calculateResult(move, computerMove))

        ivYou.setImageResource(
            resources.getIdentifier(
                move.toString().toLowerCase(Locale.getDefault()),
                "drawable",
                activity?.packageName
            )
        )
        ivComputer.setImageResource(
            resources.getIdentifier(
                computerMove.toString().toLowerCase(Locale.getDefault()),
                "drawable",
                activity?.packageName
            )
        )

        when (result) {
            1 -> tvResult.text = getString(R.string.you_win)
            0 -> tvResult.text = getString(R.string.draw)
            -1 -> tvResult.text = getString(R.string.you_lose)
        }
    }

    private fun calculateResult (playerMove: Game.Move?, computerMove: Game.Move?): Int {
        return if (playerMove == computerMove) {
            Game.Result.DRAW.value
        } else if ((playerMove == Game.Move.ROCK && computerMove == Game.Move.SCISSORS) ||
            (playerMove == Game.Move.PAPER && computerMove == Game.Move.ROCK) ||
            (playerMove == Game.Move.SCISSORS && computerMove == Game.Move.PAPER)
        ) {
            Game.Result.WIN.value
        } else {
            Game.Result.LOSS.value
        }
    }









}
package com.example.madlevel4task2v2.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.madlevel4task2v2.R
import com.example.madlevel4task2v2.model.Game.Move
import com.example.madlevel4task2v2.model.Game.Result
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
        ivRock.setOnClickListener{ playGame(Move.ROCK) }
        ivPaper.setOnClickListener{ playGame(Move.PAPER) }
        ivScissors.setOnClickListener{ playGame(Move.SCISSORS) }
    }


    private fun playGame(move: Move) {
        val computerMove = Move.values().toList().shuffled().first()

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
            Result.WIN -> tvResult.text = getString(R.string.you_win)
            Result.DRAW -> tvResult.text = getString(R.string.draw)
            Result.LOSE -> tvResult.text = getString(R.string.you_lose)
        }
    }

    private fun calculateResult (playerMove: Move, computerMove: Move): Result {
        return if (playerMove == computerMove) {
            Result.DRAW
        } else if ((playerMove == Move.ROCK && computerMove == Move.SCISSORS) ||
            (playerMove == Move.PAPER && computerMove == Move.ROCK) ||
            (playerMove == Move.SCISSORS && computerMove == Move.PAPER)
        ) {
            Result.WIN
        } else {
            Result.LOSE
        }
    }









}
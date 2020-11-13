package com.example.madlevel4task2v2.repository

import android.content.Context
import com.example.madlevel4task2v2.dao.GameDao
import com.example.madlevel4task2v2.database.GameDatabase
import com.example.madlevel4task2v2.model.Game


class GameRepository(context: Context) {

    private val gameDao: GameDao

    init {
        val database = GameDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }

    suspend fun getAllGames(): List<Game> {
        return gameDao.getAllGames()
    }

    suspend fun insertGame(game: Game) {
        gameDao.insertGame(game)
    }

    suspend fun deleteGame(game: Game) {
        gameDao.deleteGame(game)
    }

    suspend fun deleteAllGames() {
        gameDao.deleteAllGames()
    }

    suspend fun getNumberOfWins() = gameDao.getNumberOfWins()

    suspend fun getNumberOfDraws() = gameDao.getNumberOfDraws()

    suspend fun getNumberOfLosses() = gameDao.getNumberOfLosses()
}

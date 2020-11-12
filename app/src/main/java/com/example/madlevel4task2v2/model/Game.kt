package com.example.madlevel4task2v2.model

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "game_table")
data class Game(

    @ColumnInfo(name = "date")
    var date: Date,

    @ColumnInfo(name = "move_computer")
    var moveComputer: Move,

    @ColumnInfo(name = "move_player")
    var movePlayer: Move,

    @ColumnInfo(name = "result")
    var result: Result,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
) {
    enum class Move {
        ROCK, PAPER, SCISSORS
    }

    enum class Result {
        LOSE, DRAW, WIN
    }
}
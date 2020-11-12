package com.example.madlevel4task2v2.converter

import androidx.room.TypeConverter
import com.example.madlevel4task2v2.model.Game
import java.util.*

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromMove(value: Int?): Game.Move? {
        return value?.let {
            when (it) {
                -1 -> Game.Move.ROCK
                0 -> Game.Move.PAPER
                1 -> Game.Move.SCISSORS
                else -> Game.Move.ROCK
            }
        }
    }

    @TypeConverter
    fun moveToInt(move: Game.Move?): Int? {
        return move?.let {
            when (it) {
                Game.Move.ROCK -> -1
                Game.Move.PAPER -> 0
                Game.Move.SCISSORS -> 1
            }
        }
    }

    @TypeConverter
    fun fromResult(value: Int?): Game.Result? {
        return value?.let {
            when (it) {
                -1 -> Game.Result.LOSE
                0 -> Game.Result.DRAW
                1 -> Game.Result.WIN
                else -> Game.Result.LOSE
            }
        }
    }

    @TypeConverter
    fun resultToInt(result: Game.Result?): Int? {
        return result?.let {
            when (it) {
                Game.Result.LOSE -> -1
                Game.Result.DRAW -> 0
                Game.Result.WIN -> 1
            }
        }
    }
}
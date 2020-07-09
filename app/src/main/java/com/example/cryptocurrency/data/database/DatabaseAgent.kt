package com.example.cryptocurrency.data.database

import androidx.room.Room
import com.example.cryptocurrency.application.ThisApp

object DatabaseAgent {

    val api: DatabaseApi by lazy {
        return@lazy Room.databaseBuilder(
            ThisApp.app, DatabaseApi::class.java, "cryptocurrency"
        )
            .setTransactionExecutor(ThisApp.executors)
            .setQueryExecutor(ThisApp.executors)
            .fallbackToDestructiveMigration()
            .build()
    }

}
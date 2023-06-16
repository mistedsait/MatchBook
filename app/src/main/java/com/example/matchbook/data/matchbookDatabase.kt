package com.example.matchbook.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [login_info::class], version = 1, exportSchema = false)
abstract class MatchbookDatabase : RoomDatabase() {

    abstract fun loginDao(): LoginDao

    companion object {
        @Volatile
        private var instance: MatchbookDatabase? = null

        fun getInstance(context: Context): MatchbookDatabase {
            return instance ?: synchronized(this) {
                val newInstance = Room.databaseBuilder(
                    context.applicationContext,
                    MatchbookDatabase::class.java,
                    "MatchBook Database"
                ).build()
                instance = newInstance
                newInstance
            }
        }
    }
}
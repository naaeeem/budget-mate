package com.example.budgetmate

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BudgetItems::class], version = 1)
abstract class BudgetDatabase : RoomDatabase() {

    abstract fun getBudgetDao() : BudgetDao

    companion object {
        @Volatile
        private var INSTANCE : BudgetDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE?: synchronized(LOCK) {
            INSTANCE?: createDatebase(context).also {
                INSTANCE = it
            }
        }

        private fun createDatebase(context: Context) =
            Room.databaseBuilder(context.applicationContext, BudgetDatabase::class.java, "Budget.db").build()
    }

}
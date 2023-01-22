package com.example.budgetmate

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BudgetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: BudgetItems)

    @Delete
    suspend fun delete(item: BudgetItems)

    @Query("SELECT * FROM budget_items")
    fun getAllBudgetItems() : LiveData<List<BudgetItems>>
}
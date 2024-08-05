package com.subhipandey.expensetracker.data.local
import androidx.room.Database
import androidx.room.RoomDatabase
import com.subhipandey.expensetracker.model.Transaction

@Database(
    entities = [Transaction::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getTransactionDao(): TransactionDao
}
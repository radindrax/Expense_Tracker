package com.subhipandey.expensetracker.repo
import com.subhipandey.expensetracker.data.local.AppDatabase
import com.subhipandey.expensetracker.model.Transaction
import javax.inject.Inject

class TransactionRepo @Inject constructor(private val db: AppDatabase) {


    suspend fun insert(transaction: Transaction) = db.getTransactionDao().insertTransaction(
        transaction
    )


    suspend fun update(transaction: Transaction) = db.getTransactionDao().updateTransaction(
        transaction
    )


    suspend fun delete(transaction: Transaction) = db.getTransactionDao().deleteTransaction(
        transaction
    )


    fun getAllTransactions() = db.getTransactionDao().getAllTransactions()


    fun getAllSingleTransaction(transactionType: String) = if (transactionType == "Overall") {
        getAllTransactions()
    } else {
        db.getTransactionDao().getAllSingleTransaction(transactionType)
    }


    fun getByID(id: Int) = db.getTransactionDao().getTransactionByID(id)


    suspend fun deleteByID(id: Int) = db.getTransactionDao().deleteTransactionByID(id)
}
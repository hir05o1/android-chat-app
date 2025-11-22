package dev.hir05o1.chat_app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import dev.hir05o1.chat_app.data.models.ReactionModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ReactionDao {
    @Query("SELECT * FROM reactions WHERE id = :id")
    fun observeById(id: Int): Flow<ReactionModel?>

    @Query("SELECT * FROM reactions WHERE messageId = :messageId ORDER BY createdAt DESC")
    fun observeByMessage(messageId: Int): Flow<List<ReactionModel>>

    @Query("SELECT * FROM reactions WHERE userId = :userId ORDER BY createdAt DESC")
    fun observeByUser(userId: Int): Flow<List<ReactionModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(reaction: ReactionModel): Long

    @Update
    suspend fun update(reaction: ReactionModel): Int
}


package dev.hir05o1.chat_app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import dev.hir05o1.chat_app.data.models.MessageModel
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {
    @Query("SELECT * FROM messages WHERE id = :id")
    fun observeById(id: Int): Flow<MessageModel?>

    @Query("SELECT * FROM messages WHERE userId = :userId ORDER BY createdAt DESC")
    fun observeByUser(userId: Int): Flow<List<MessageModel>>

    @Query("SELECT * FROM messages WHERE replyId = :parentId ORDER BY createdAt ASC")
    fun observeReplies(parentId: Int): Flow<List<MessageModel>>

    @Query("SELECT * FROM messages ORDER BY createdAt DESC")
    fun observeAll(): Flow<List<MessageModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(message: MessageModel): Long

    @Update
    suspend fun update(message: MessageModel): Int
}


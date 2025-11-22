package dev.hir05o1.chat_app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import dev.hir05o1.chat_app.data.models.UserModel
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE id = :id")
    fun observeById(id: Int): Flow<UserModel?>

    @Query("SELECT * FROM users ORDER BY createdAt DESC")
    fun observeAll(): Flow<List<UserModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserModel): Long

    @Update
    suspend fun update(user: UserModel): Int
}

